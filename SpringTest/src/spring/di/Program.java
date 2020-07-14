package spring.di;

import spring.di.enity.Exam;
import spring.di.enity.NewlecExam;
import spring.di.ui.ExamConsole;

public class Program {

	public static void main(String[] args) {
		
		Exam exam = new NewlecExam();
		ExamConsole console = new ExamConsole(exam);
		console.print();
	}

}
