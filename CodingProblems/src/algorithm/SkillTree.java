package algorithm;

public class SkillTree {

	public static void main(String[] args) {
		String skill = "CBD";
		String[] skillTrees = {"BACDE", "CBADF", "AECB", "BDA"};
		
		int res = getNumberOfSkillTrees(skill, skillTrees);
		System.out.println(res);
	}
	
	public static int getNumberOfSkillTrees(String skill, String[] skillTrees) {
		int[] countArray = new int[26];
		int res = 0;
		
		for (int i = 0; i < skill.length(); i++)
			countArray[skill.charAt(i) - 'A'] = i + 1;
		
		for (String skillTree : skillTrees) {
			int idx = 1;
			boolean isPossible = true;

			for (char c : skillTree.toCharArray()) {
				if (countArray[c - 'A'] == 0)
					continue;
				
				if (countArray[c - 'A'] != idx) {
					isPossible = false;
					break;
				}
				idx++;
			}
			if (isPossible)
				res++;
		}
		return res;
	}
}
