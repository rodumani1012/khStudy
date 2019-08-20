package class10_class.ep01_calssdesign.book;

public class MainBook {

	public static void main(String[] args) {

		// Object 1
		Book b1 = new Book();
		b1.setCategory("만화"); // 카테고리
		b1.setTitle("열혈강호"); // 제목
		b1.setAuthor("전극진, 양재헌"); // 작가
		b1.setPublisher("대원씨아이"); // 출판사
		b1.setPrice(4500); // 가격
		b1.printInfo();

		// Object 2
		Book b2 = new Book();
		b2.setCategory("여행");
		b2.setTitle("이탈리아 여행백서");
		b2.setAuthor("염승범");
		b2.setPublisher("나무자전거");
		b2.setPrice(18000);
		b2.printInfo();
	}

}
