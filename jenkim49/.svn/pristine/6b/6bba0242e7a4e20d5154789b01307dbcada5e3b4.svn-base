package jenkim49.product;

public class PageMaker {
	
	private int page;
	private int count;
	private int start;
	private int end;
	private boolean prev;
	private boolean next;
	
	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public boolean getPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean getNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if (page<1) {
			this.page = 1;
			return;
		}
		this.page = page;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		if(count<1) {
			return;
		}
		this.count = count;
		System.err.println("total column num: "+count);
	}

	public void calcPage() {
		int tempEnd = (int)(Math.ceil(page/10.0)*10);
		// 페이지 변수는 현재 페이지 번호, 현재 페이지번호를 기준으로 끝 페이지를 계산한다
		
		System.out.println("page= "+page);
		System.out.println("tempEnd= "+tempEnd);
		System.out.println("this.count= "+this.count);
		
		this.start = tempEnd - 9;
		// 시작 페이지 계산 
		
		if(tempEnd*10 > this.count) {
			this.end = (int) Math.ceil(this.count/10.0);
		} else {
			this.end = tempEnd;
		}
		
		System.err.println("this.end= "+this.end);
		this.prev = this.start != 1;
		this.next = this.end * 10 < this.count;
		
	}
}
