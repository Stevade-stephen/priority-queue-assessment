package com.stevade;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PriorityTest {

    @Test
    void shouldReturnTheRemainingStudentsInTheQueue() {
        Priority priority = new Priority();
        List<String> events = List.of (
                "12",
                "ENTER John 3.75 50",
                "ENTER Mark 3.8 24",
                "ENTER Shafaet 3.7 35",
                "SERVED",
                "SERVED",
                "ENTER Samiha 3.85 36",
                "SERVED",
                "ENTER Ashley 3.9 42",
                "ENTER Maria 3.6 46",
                "ENTER Anik 3.95 49",
                "ENTER Dan 3.95 50",
                "SERVED"
        );

        List<Student> studentList = priority.getStudentList(events);
        System.out.println(studentList);
        assertThat(studentList.size()).isEqualTo(4);
        assertThat(studentList.get(0).getName()).isEqualTo("Dan");
        assertThat(studentList.get(studentList.size() - 1).getName()).isEqualTo("Maria");
    }
}