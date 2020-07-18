package spring.di.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import spring.di.entity.Exam;

@Component("console")
public class InlineExamConsole implements ExamConsole {

	// 기본 생성자가 생성되면서 호출됨, 기본 생성자만 없으면 안되고 없으려면 오버로드 생성자까지 다 없애야함
	@Autowired // required = false로 빈 객체를 null값으로 보낼 수 있음
	//@Qualifier("exam2") // 일반적으로 이 위치에 많이 씀
	private Exam exam;
	
	public InlineExamConsole() {
		System.out.println("constuctor");
	}
	
	//@Autowired
	//@Qualifier("exam2")// : 파라미터가 두개 이상 있을수도 있으므로 생성자앞에 써줌 ex) Function(@Qualifier("exam2")Exam exam) 
	public InlineExamConsole(/*@Qualifier("exam2")*/Exam exam) {
		System.out.println("overloaddd");
		this.exam = exam;
	}
	
	@Override
	public void print() {
		if(exam==null)
			System.out.printf("total is %d, avg is %f\n", 0, 0.0);
		else
			System.out.printf("total is %d, avg is %f\n", exam.total(), exam.avg());

	}

	 //@Autowired // Autowired와 Qulifier는 아무대나 심을 수 있음. (Setter함수가 호출되면서 인젝션 생성) 
	 //@Qualifier("exam2") // 생성자 bean의 id와 비교하여 찾아감
 	@Override
	public void setExam(Exam exam) {
		System.out.println("setter injection");
		this.exam = exam;
	}

}
