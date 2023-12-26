package com.schools.school.controller;

import com.schools.school.entity.*;
import com.schools.school.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class StudentRegistrationController {
    @Autowired
    private final SeniorOneService seniorOneService;
    @Autowired
    private final SeniorTwoService seniorTwoService;
    @Autowired
    private final SeniorThreeService seniorThreeService;
    @Autowired
    private final SeniorFourService seniorFourService;
    @Autowired
    private final StudentRegistrationService studentRegistrationService;
    private List<StudentRegistration> selectedStudent = new ArrayList<StudentRegistration>();
    private Long id;
    @Autowired
    private FileStorageService fileStorageService;


    public StudentRegistrationController(SeniorOneService seniorOneService,
                                         SeniorTwoService seniorTwoService,
                                         SeniorThreeService seniorThreeService,
                                         SeniorFourService seniorFourService,
                                         StudentRegistrationService studentRegistrationService) {
        this.seniorOneService = seniorOneService;
        this.seniorTwoService = seniorTwoService;
        this.seniorThreeService = seniorThreeService;
        this.seniorFourService = seniorFourService;
        this.studentRegistrationService = studentRegistrationService;

    }


    @GetMapping("/api")
    public String home() {
        return "home";
    }

    @GetMapping("/studentForm")
    public String showStudentForm(Model model) {
        model.addAttribute("student", new StudentRegistration());
        return "students";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") StudentRegistration studentRegistration,
                              @RequestParam("studentPhoto") MultipartFile studentPhoto) {
        if (!studentPhoto.isEmpty()) {
            String fileName = "student_" + studentRegistration.getId() + "_" + UUID.randomUUID() +
                    StringUtils.getFilenameExtension(studentPhoto.getOriginalFilename());

            // Save the file to your storage service
            fileStorageService.saveFile(fileName, studentPhoto);

            // Save the file path to the studentRegistration or database
            studentRegistration.setStudentPhotoPath(fileName);
        }

        studentRegistrationService.saveStudentInformation(studentRegistration);
        return "redirect:/api/student/list";
    }

    @RequestMapping("/api/student/list")
    public String listStudentRegistered(Model model) {
        List<StudentRegistration> students = studentRegistrationService.getAllStudents();
        model.addAttribute("students", students);
        return "student_List";
    }


    @GetMapping("/student/new")
    public String createStudentForm(Model model) {
        // Create the object
        StudentRegistration studentRegistration = new StudentRegistration();
        model.addAttribute("students", studentRegistration);
        return "new_student";

    }

//    @GetMapping("/api/student/single/{id}")
//    public StudentRegistration getSingleStudent(@PathVariable Long id) {
//        StudentRegistration studentRegistration = studentRegistrationService.getStudentRegistrationById(id);
//        if (studentRegistrationService == null) {
//            throw new IllegalArgumentException("student not registered with an ID " + id);
//        }
//        return studentRegistration;
//    }

//    @GetMapping("/search/name")
//    public StudentRegistration getStudentByFirstName(@PathVariable String firstName) {
//        StudentRegistration studentRegistration = studentRegistrationService.getStudentByFirstName(firstName);
//        if (studentRegistrationService == null) {
//            throw new IllegalArgumentException("No student name matches your search" + firstName);
//        }
//        return studentRegistration;
//    }




    @RequestMapping("/update/{id}")
    public String updateStudentRecord(@PathVariable("id") Long id, Model model) {
   StudentRegistration studentRegistration = studentRegistrationService.getStudentById(id);
   model.addAttribute("students",studentRegistration);
        return "edit_student";
    }

//        if (existingStudent != null) {
//            if (studentRegistration.getStudentFirstName() != null) {
//                existingStudent.setStudentFirstName(studentRegistration.getStudentFirstName());
//            }
//            if (studentRegistration.getStudentMidName() != null) {
//                existingStudent.setStudentMidName(studentRegistration.getStudentMidName());
//            }
//            if (studentRegistration.getStudentLastName() != null) {
//                existingStudent.setStudentLastName(studentRegistration.getStudentLastName());
//            }
//            if (studentRegistration.getStudentDateOfBirth() != null) {
//                existingStudent.setStudentDateOfBirth(studentRegistration.getStudentDateOfBirth());
//            }
//            if (studentRegistration.getStudentNationalIdentificationNumberNIN() != null) {
//                existingStudent.setStudentNationalIdentificationNumberNIN(studentRegistration
//                        .getStudentNationalIdentificationNumberNIN());
//            }
//            if (studentRegistration.getStudentGender() != null) {
//                existingStudent.setStudentGender(studentRegistration.getStudentGender());
//            }
//            if (studentRegistration.getStudentClass() != null) {
//                existingStudent.setStudentClass(studentRegistration.getStudentClass());
//            }
//            if (studentRegistration.getStudentHealthRecord() != null) {
//                existingStudent.setStudentHealthRecord(studentRegistration.getStudentHealthRecord());
//            }
//            if (studentRegistration.getStudentPhoto() != null) {
//                existingStudent.setStudentPhoto(studentRegistration.getStudentPhoto());
//            }
//            if (studentRegistration.getStudentHomeAddress() != null) {
//                existingStudent.setStudentHomeAddress(studentRegistration.getStudentHomeAddress());
//            }
//
//            if (studentRegistration.getStudentSubCounty() != null) {
//                existingStudent.setStudentSubCounty(studentRegistration.getStudentSubCounty());
//            }
//            if (studentRegistration.getStudentDistrict() != null) {
//                existingStudent.setStudentDistrict(studentRegistration.getStudentDistrict());
//            }
//
//            studentRegistrationService.updateStudentRecords(existingStudent);
//            return "edit_student"; // Redirect to the list of students
//        } else {
//            // Handle the case where the student with the given ID is not found
//            model.addAttribute("student", "Student not found with ID: " + id);
//            return "error_page"; // Create an error page template for handling such cases
//        }


    @GetMapping("/api/student/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        if (!studentRegistrationService.existsById(id)) {
            throw new IllegalArgumentException("student not found by the id");
        }
        studentRegistrationService.deleteStudentRecordById(id);
        return "redirect:/api/student/list";
    }

    @GetMapping("/gender/{gender}")
    public String getStudentByGender(@PathVariable String gender, Model model) {
        List<StudentRegistration> students = studentRegistrationService.getByGender(gender);

        if (students.isEmpty()) {
            return "noStudentsFound"; // This should be a Thymeleaf template name indicating no students found
        }

        model.addAttribute("students", students);
        return "gender"; // This should be a Thymeleaf template name displaying the students
    }



    @GetMapping("/seniorOne")
    public String getSeniorOne(Model model) {
        List<SeniorOne> list = seniorOneService.getAllSeniorList();
        model.addAttribute("students", list);
        return "senior_List";
    }
    // this method is tested

    @RequestMapping("/saveToS1/{id}")
    public String getSeniorOneList(@PathVariable("id") Long id) {
        StudentRegistration studentRegistration = studentRegistrationService.getStudentById(id);
        SeniorOne seniorOne = new SeniorOne(studentRegistration.getId(),
                studentRegistration.getStudentFirstName(),
                studentRegistration.getStudentMidName(),
                studentRegistration.getStudentLastName(),
                studentRegistration.getStudentDateOfBirth(),
                studentRegistration.getStudentNationalIdentificationNumberNIN(),
                studentRegistration.getStudentGender(),
                studentRegistration.getStudentClass(),
                studentRegistration.getFeesToBeePaid(),
                studentRegistration.getStudentHealthRecord(),
                studentRegistration.getFormerSchoolName(),
                studentRegistration.getReasonWhyChangedSchool(),
                studentRegistration.getFormerSchoolPerformanceRecords(),
                studentRegistration.getStudentPhotoPath(),
                studentRegistration.getStudentHomeAddress(),
                studentRegistration.getStudentSubCounty(),
                studentRegistration.getStudentDistrict());
        seniorOneService.saveToSeniorOne(seniorOne);
        selectedStudent.add(studentRegistration);
        return "redirect:/seniorOne";
    }

    @RequestMapping("/seniorOne/update/{id}")
    public String updateSeniorOneRecord(@PathVariable("id") Long id, Model model) {
        SeniorOne seniorOne = seniorOneService.getSeniorOneById(id);
        model.addAttribute("student", seniorOne);
        return "edit_student";
    }

    @GetMapping("/delete/seniorOne/{id}")
    public String deleteSeniorOne(@PathVariable("id") Long id) {
        if (!seniorOneService.existById(id)) {
            throw new IllegalArgumentException("No records found with the ID in senior One");
        }
        seniorOneService.deleteSeniorOneById(id);
        return "records deleted successfully";
    }

    @GetMapping("/seniorTwo")
    public String getSeniorTwo(Model model) {
        List<SeniorTwo> list = seniorTwoService.getAllSeniorList();
        model.addAttribute("students", list);
        return "seniorTwo_List";
    }

    @RequestMapping("/saveSeniorTwo/{id}")
    public String getSeniorTwoList(@PathVariable("id") Long id) {
        StudentRegistration studentRegistration = studentRegistrationService.getStudentById(id);
        SeniorTwo seniorTwo = new SeniorTwo(studentRegistration.getId(),
                studentRegistration.getStudentFirstName(),
                studentRegistration.getStudentMidName(),
                studentRegistration.getStudentLastName(),
                studentRegistration.getStudentDateOfBirth(),
                studentRegistration.getStudentNationalIdentificationNumberNIN(),
                studentRegistration.getStudentGender(),
                studentRegistration.getStudentClass(),
                studentRegistration.getFeesToBeePaid(),
                studentRegistration.getStudentHealthRecord(),
                studentRegistration.getFormerSchoolName(),
                studentRegistration.getReasonWhyChangedSchool(),
                studentRegistration.getFormerSchoolPerformanceRecords(),
                studentRegistration.getStudentPhotoPath(),
                studentRegistration.getStudentHomeAddress(),
                studentRegistration.getStudentSubCounty(),
                studentRegistration.getStudentDistrict());
        seniorTwoService.saveToSeniorTwo(seniorTwo);
        selectedStudent.add(studentRegistration);

        return "redirect:/seniorTwo";
    }

    @GetMapping("/seniorThree")
    public String getSeniorThree(Model model) {
        List<SeniorThree> list = seniorThreeService.getAllSeniorList();
        model.addAttribute("students", list);
        return "seniorThree_List";
    }

    @RequestMapping("/saveSeniorThree/{id}")
    public String getSeniorThreeList(@PathVariable("id") Long id) {
        StudentRegistration studentRegistration = studentRegistrationService.getStudentById(id);
        SeniorThree seniorThree = new SeniorThree(studentRegistration.getId(),
                studentRegistration.getStudentFirstName(),
                studentRegistration.getStudentMidName(),
                studentRegistration.getStudentLastName(),
                studentRegistration.getStudentDateOfBirth(),
                studentRegistration.getStudentNationalIdentificationNumberNIN(),
                studentRegistration.getStudentGender(),
                studentRegistration.getStudentClass(),
                studentRegistration.getFeesToBeePaid(),
                studentRegistration.getStudentHealthRecord(),
                studentRegistration.getFormerSchoolName(),
                studentRegistration.getReasonWhyChangedSchool(),
                studentRegistration.getFormerSchoolPerformanceRecords(),
                studentRegistration.getStudentPhotoPath(),
                studentRegistration.getStudentHomeAddress(),
                studentRegistration.getStudentSubCounty(),
                studentRegistration.getStudentDistrict());
        seniorThreeService.saveToSeniorThree(seniorThree);
        selectedStudent.add(studentRegistration);

        return "redirect:/seniorThree";
    }

    @GetMapping("/seniorFour")
    public String getSeniorFour(Model model) {
        List<SeniorFour> list = seniorFourService.getAllSeniorList();
        model.addAttribute("students", list);
        return "seniorFour_List";
    }

    @RequestMapping("/saveSeniorFour/{id}")
    public String getSeniorFourList(@PathVariable("id") Long id) {
        StudentRegistration studentRegistration = studentRegistrationService.getStudentById(id);
        SeniorFour seniorFour = new SeniorFour(studentRegistration.getId(),
                studentRegistration.getStudentFirstName(),
                studentRegistration.getStudentMidName(),
                studentRegistration.getStudentLastName(),
                studentRegistration.getStudentDateOfBirth(),
                studentRegistration.getStudentNationalIdentificationNumberNIN(),
                studentRegistration.getStudentGender(),
                studentRegistration.getStudentClass(),
                studentRegistration.getFeesToBeePaid(),
                studentRegistration.getStudentHealthRecord(),
                studentRegistration.getFormerSchoolName(),
                studentRegistration.getReasonWhyChangedSchool(),
                studentRegistration.getFormerSchoolPerformanceRecords(),
                studentRegistration.getStudentPhotoPath(),
                studentRegistration.getStudentHomeAddress(),
                studentRegistration.getStudentSubCounty(),
                studentRegistration.getStudentDistrict());
        seniorFourService.saveToSeniorFour(seniorFour);
        selectedStudent.add(studentRegistration);

        return "redirect:/seniorFour";
    }

}
