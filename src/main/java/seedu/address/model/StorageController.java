package seedu.address.model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

import seedu.address.commons.util.XmlUtil;
import seedu.address.model.classroom.Classroom;
import seedu.address.model.classroom.ClassroomManager;
import seedu.address.model.note.Note;

/**
 * This class is a storage controller for the other datasets that work alongside the main student list.
 */
public class StorageController {

    private static final String STORAGE_COURSES = "courseList.xml";
    private static final String STORAGE_MODULES = "modules.xml";
    private static final String STORAGE_CLASSES = "classes.xml";
    private static final String STORAGE_GRADEBOOK = "gradebook.xml";
    private static final String STORAGE_NOTES = "notes.xml";

    private static ArrayList<Course> courseStorage = new ArrayList<Course>();
    private static ArrayList<Module> moduleStorage = new ArrayList<Module>();
    private static ArrayList<Classroom> classesStorage = new ArrayList<Classroom>();
    private static ArrayList<Course> gradebookStorage = new ArrayList<Course>();
    private static ArrayList<Note> noteStorage = new ArrayList<Note>();




    /**
     * This method retrieves all datasets saved locally.
     */
    public static void retrieveData() {
        createFiles();

        try {
            CourseManager cm = XmlUtil.getDataFromFile(Paths.get(STORAGE_COURSES), CourseManager.class);
            courseStorage = cm.getList();

            ModuleManager moduleManager = XmlUtil.getDataFromFile(Paths.get(STORAGE_MODULES), ModuleManager.class);
            moduleStorage = moduleManager.getModules();

            ClassroomManager crm = (ClassroomManager) XmlUtil.getDataFromFile(
                    Paths.get(STORAGE_CLASSES), ClassroomManager.class);
            classesStorage = crm.getList();

            NotesManager nm = (NotesManager) XmlUtil.getDataFromFile(Paths.get(STORAGE_NOTES), NotesManager.class);
            noteStorage = nm.getList();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     This method creates files for all datasets if they do not exist on the local filesystem.
     */
    private static void createFiles() {
        File gradebook = new File(STORAGE_GRADEBOOK);
        File classes = new File(STORAGE_CLASSES);
        File courses = new File(STORAGE_COURSES);
        File modules = new File(STORAGE_MODULES);
        File notes = new File(STORAGE_NOTES);
        try {
            gradebook.createNewFile();
            classes.createNewFile();
            courses.createNewFile();
            modules.createNewFile();
            notes.createNewFile();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
  This method stores all data within the arraylists above to local storage.
   */
    public static void storeData() {
        try {
            CourseManager cm = new CourseManager();
            cm.setCourseList(courseStorage);
            XmlUtil.saveDataToFile(Paths.get(STORAGE_COURSES), cm);
            ModuleManager moduleManager = new ModuleManager();
            moduleManager.setModules(moduleStorage);
            XmlUtil.saveDataToFile(Paths.get(STORAGE_MODULES), moduleManager);

            ClassroomManager crm = new ClassroomManager();
            crm.setClassroomList(classesStorage);
            XmlUtil.saveDataToFile(Paths.get(STORAGE_CLASSES), crm);

            NotesManager nm = new NotesManager();
            nm.setNotesList(noteStorage);
            XmlUtil.saveDataToFile(Paths.get(STORAGE_NOTES), nm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Course> getCourseStorage() {
        return courseStorage;
    }

    public static void setCourseStorage(ArrayList<Course> courseStorage) {
        StorageController.courseStorage = courseStorage;
    }

    public static ArrayList<Module> getModuleStorage() {
        return moduleStorage;
    }

    public static void setModuleStorage(ArrayList<Module> moduleStorage) {
        StorageController.moduleStorage = moduleStorage;
    }

    public static ArrayList<Classroom> getClassesStorage() {
        return classesStorage;
    }

    public static void setClassesStorage(ArrayList<Classroom> classesStorage) {
        StorageController.classesStorage = classesStorage;
    }

    public static ArrayList<Course> getGradebookStorage() {
        return gradebookStorage;
    }

    public static void setGradebookStorage(ArrayList<Course> gradebookStorage) {
        StorageController.gradebookStorage = gradebookStorage;
    }

    public static ArrayList<Note> getNoteStorage() {
        return noteStorage;
    }

    public static void setNoteStorage(ArrayList<Note> noteStorage) {
        StorageController.noteStorage = noteStorage;
    }
}
