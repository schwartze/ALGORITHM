package algorithm;

public class RobotVacuum {
	
	public static void main(String[] args) {
		int r = 7, c = 4, d = 0;
		int[][] area = {
				{	1, 	1, 	1, 	1, 	1, 	1, 	1, 	1, 	1, 	1	},
				{	1, 	0, 	0, 	0, 	0, 	0, 	0, 	0, 	0, 	1	},
				{	1, 	0, 	0, 	0, 	1, 	1, 	1, 	1, 	0, 	1	},
				{	1, 	0, 	0, 	1, 	1, 	0, 	0, 	0, 	0, 	1	},
				{	1, 	0, 	1, 	1, 	0, 	0, 	0, 	0, 	0, 	1	},
				{	1, 	0, 	0, 	0, 	0, 	0, 	0, 	0, 	0, 	1	},
				{	1, 	0, 	0, 	0, 	0, 	0, 	0, 	1, 	0, 	1	},
				{	1, 	0, 	0, 	0, 	0, 	0, 	1, 	1, 	0, 	1	},
				{	1, 	0, 	0, 	0, 	0, 	0, 	1, 	1, 	0, 	1	},
				{	1, 	0, 	0, 	0, 	0, 	0, 	0, 	0, 	0, 	1	},
				{	1, 	1, 	1, 	1, 	1, 	1, 	1, 	1, 	1, 	1	}
			};
		
		RobotVacuum vacuum = new RobotVacuum();
		int res = vacuum.getCleanedArea(r, c, d, area);
		System.out.println(res);
	}
	
	public int getCleanedArea(int r, int c, int d, int[][] area) {
		// NESW (0123)
		// d: N(0) -> c--
		//    E(1) -> r++
		//    S(2) -> c++
		//    W(3) -> r--
		int cleanedArea = 1;
		area[r][c]--;
		int[] yx = {r, c};
		
		while (true) {
			// NESW 모두 청소된 경우
			if (allCleaned(yx, area)) {
				int[] shifted = shiftBack(yx, d, area);
				if (shifted[0] == -2 && shifted[1] == -2)
					break;

				yx = shifted;
				continue;
			}
			int[] left = cleanLeft(yx, d, area);
			
			// 왼쪽 청소 불가능: 왼쪽으로 방향 전환 후 재시도
			if (left[0] == yx[0] && left[1] == yx[1]) {
				d = d == 0 ? 3 : d - 1;
				continue;
			}
			// 왼쪽 청소 가능: 현 위치에서 왼쪽으로 방향 전환 
			d = d == 0 ? 3 : d - 1;
			// 왼쪽 청소
			cleanedArea++;
			// 앞 쪽으로 한칸 이동 
			yx = left;
			// 해당 영역 청소 완료 표기
			area[yx[0]][yx[1]]--;
		}
		
		return cleanedArea;
	}

	private int[] cleanLeft(int[] yx, int d, int[][] area) {
		int r = yx[0], c = yx[1];
		int[] left = {r, c};
		d = d == 0 ? 3 : d - 1;
		
		if (d == 0 && area[r - 1][c] == 0) {
			left[0]--;
		} else if (d == 1 && area[r][c + 1] == 0) {
			left[1]++;
		} else if (d == 2 && area[r + 1][c] == 0) {
			left[0]++;
		} else if (d == 3 && area[r][c - 1] == 0) {
			left[1]--;
		}
		
		return left;
	}
	
	private boolean allCleaned(int[] yx, int[][] area) {
		int r = yx[0], c = yx[1];
		boolean cleaned = true;
		
		if (area[r][c + 1] == 0 || area[r + 1][c] == 0 || 
				area[r][c - 1] == 0 || area[r - 1][c] == 0)
			cleaned = false;

		return cleaned;
	}
	
	private int[] shiftBack(int[] yx, int d, int[][] area) {
		int r = yx[0], c = yx[1];
		int[] shifted = {r, c};

		if (d == 0 && r + 1 != area.length - 1) {
			shifted[0]++;
		} else if (d == 1 && c - 1 != 0) {
			shifted[1]--;
		} else if (d == 2 && r - 1 != 0) {
			shifted[0]--;
		} else if (d == 3 && c + 1 != area[0].length - 1) {
			shifted[1]++;
		}

		if (shifted[0] == r && shifted[1] == c) {
			shifted[0] = -2;
			shifted[1] = -2;
		}
		return shifted;
	}















}
