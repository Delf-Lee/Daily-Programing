package codingtest.naver2019;

/**
 * @author delf
 */
public class Q2 {
	private boolean starTrigger = true;

	public int solution(String[] drum) {
		int result = 0;
		for (int i = 0; i < drum[0].length(); i++) {
			result += isFallToFloor(drum, i) ? 1 : 0;
		}

		return result;
	}

	private boolean isFallToFloor(String[] drum, int startCol) {
		return getStoppedRow(drum, startCol) == -1;
	}


	private int getStoppedRow(String[] drum, int startCol) {
//		System.out.println("startCol" + startCol);
		Position startPosition = new Position(0, startCol);
		Position current = new Position(startPosition);
//		System.out.println("cur" + current);
		Position now = getBallNextPotion(startPosition, getInstruction(drum, startPosition));
		System.out.println("cur" + current);
		System.out.println("now" + now);
//		 System.out.println(!now.equals(current));
		while (!now.equals(current)) {
			current = now;
			System.out.println("cur" + current);
			System.out.println("now" + now);
			now = getBallNextPotion(now, getInstruction(drum, now));
			System.out.println("cur" + current);
			System.out.println("now" + now);
			// System.out.println(getInstruction(drum, now));
		}
		System.out.println("--");
		return startPosition.getRow();
	}

	private Position getBallNextPotion(Position now, char instruction) {
		switch (instruction) {
			case '#':
				return now.moveDown();
			case '>':
				return now.moveRight();
			case '<':
				return now.moveLeft();
			case '*':
				if (starTrigger) {
					return now.moveDown();
				}
				starTrigger = false;
		}
		throw new IllegalArgumentException();
	}

	private char getInstruction(String[] drum, Position position) {
		return drum[position.row].charAt(position.col);
	}

	class Position {
		private int col;
		private int row;

		public Position(int row, int col) {
			this.col = col;
			this.row = row;
		}

		public Position(Position position) {
			position.col = col;
			position.row = row;
		}

		public Position moveRight() {
			col++;
			return new Position(this);
		}

		public Position moveLeft() {
			col--;
			return new Position(this);
		}

		public Position moveDown() {
			row++;
			return new Position(this);
		}

		public int getRow() {
			return row;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			Position position = (Position) o;

			if (col != position.col) return false;
			return row == position.row;

		}

		@Override
		public int hashCode() {
			int result = col;
			result = 31 * result + row;
			return result;
		}

		@Override
		public String toString() {
			return "Position{" +
					"col=" + col +
					", row=" + row +
					'}';
		}
	}

	public static void main(String[] args) {
		System.out.println(new Q2().solution(new String[]{"######", ">#*###", "####*#", "#<#>>#", ">#*#*<", "######"}));
	}

}
