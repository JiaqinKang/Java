package com.company;

import java.util.Arrays;
import java.util.List;

public final class Student{
    //declare
    int studentId;
    int [] marks = new int[5];
    List listOfStudents;


    //constructor
    public Student(int C_studentID, int [] C_marks, List C_listOfStudents){
        studentId = C_studentID;
        marks = C_marks;
        listOfStudents = C_listOfStudents;
    }

    int getFinalMark(){
        int FinalMark = 0;
        for (int i = 0; i < marks.length; i ++){
            FinalMark = FinalMark + marks[i];
        }
        //work out the average mark
        FinalMark = FinalMark / marks.length+1;

        //return Average Final mark
        return FinalMark;
    };

    int getGrade(){
        char Grade = 'F';
        if (getFinalMark() <= 60 && getFinalMark() < 70){
            Grade = 'B';
        }
        if (getFinalMark() <= 50 && getFinalMark()< 60){
            Grade = 'D';
        }
        if (getFinalMark() >= 70){
            Grade = 'A';
        }
        if (getFinalMark() < 50){
            Grade = 'F';
        }
        return Grade;
    }

    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", marks=" +getFinalMark() +
                ", Grade=" + getGrade() +
                '}';
    }
}
