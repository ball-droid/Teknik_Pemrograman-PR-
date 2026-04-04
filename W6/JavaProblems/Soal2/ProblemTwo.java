package JavaProblems.Soal2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProblemTwo {
    public static void main(String[] args) {

        // Membuat daftar objek Student
        List<Student> students = Arrays.asList(
                new Student(101, "Joe"),
                new Student(103, "Zulkifli"),
                new Student(102, "Riza"),
                new Student(104, "Alice"),
                new Student(105, "Joshua"));

        // Menggunakan Stream API untuk sorting
        List<Student> ans = students.stream() // [1] Membuka stream
                .sorted((s1, s2) -> { // [2] Melakukan pengurutan

                    // Jika nama sama (tidak memperhatikan huruf besar/kecil)
                    if (s1.getName().equalsIgnoreCase(s2.getName())) {

                        // Menggunakan Integer.compare untuk menghindari overflow
                        // dibandingkan dengan cara lama: (s1.getId() - s2.getId())
                        return Integer.compare(s1.getId(), s2.getId()); // [3]

                    } else {

                        // Membandingkan nama tanpa memperhatikan huruf besar/kecil
                        return s1.getName().compareToIgnoreCase(s2.getName()); // [4]
                    }
                })
                .collect(Collectors.toList()); // [5] Mengumpulkan hasil ke List

        // Menampilkan hasil
        for (Student student : ans) {
            System.out.println(student);
        }
    }
}

// Class Student sebagai representasi data
class Student {
    private int id;
    private String name;

    // Constructor
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getter untuk id
    public int getId() {
        return id;
    }

    // Getter untuk name
    public String getName() {
        return name;
    }

    // Override toString untuk menampilkan data dengan format yang rapi
    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "'}";
    }
}