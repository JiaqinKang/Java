package com.company;

public final class UndergraduateStudent {
    int year;
    String program;
    int numberOfUnderGraduates;
    int [] marks = new int[5];


    //constructor
    public UndergraduateStudent(int C_year, String C_program, int C_numberOfUnderGraduates){
        year = C_year;
        program = C_program;
        numberOfUnderGraduates = C_numberOfUnderGraduates;
    }

    int GetFinalMark (int [] marks){
        //sorting the grade from lowest to highest
        boolean sorted = false;
        int temp;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < marks.length - 1; i++) {
                if (marks[i] > marks[i+1]) {
                    temp = marks[i];
                    marks[i] = marks[i+1];
                    marks[i+1] = temp;
                    sorted = false;
                }
            }
        }

        int averageMark = (marks[marks.length -1] + marks[marks.length-2] +marks[marks.length-3]) / 3;
        return  averageMark;
    }









}
