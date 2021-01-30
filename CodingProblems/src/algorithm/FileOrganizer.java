package algorithm;

import java.util.Arrays;
import java.util.Comparator;

public class FileOrganizer {

	public static void main(String[] args) {
		String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
		
		String[] files2 = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};

		String[] files3 = {"img000012345", "img1.png", "img2", "IMG02"};
		
		String[] files4 = {"A-011.png", "B-02.png"};
		
		String[] files5 = {"F-15", "F15", "B-4", "B2"};
		
		String[] files6 = {"img100.p2ng", "img202.png123", "IMG102.ps200", "image01.333png", "imag1"};
		
		FileOrganizer fOrganizer = new FileOrganizer();
		String[] sortedFiles = fOrganizer.organize(files2);
		
		for (String f : sortedFiles)
			System.out.println(f);
	}
	
	public String[] organize(String[] files) {
		Arrays.sort(files, new FileComparator());
		
		return files;
	}

	class FileComparator implements Comparator<String> {

		private String[] getHeadAndNumber(String file) {
			String[] result = new String[2];

			String[] splitedFile = file.split("[^0-9]");
			
			for (int i = 0; i < splitedFile.length; i++) {
				if (splitedFile[i].length() > 0) {
					result[0] = file.substring(0, file.indexOf(splitedFile[i]));
					if (splitedFile[i].length() > 5)
						result[1] = splitedFile[i].substring(0,  5);
					else 
						result[1] = splitedFile[i];
					break;
				}
			}
			return result;
		}
		
		@Override
		public int compare(String file1, String file2) {
			String[] file1Info = getHeadAndNumber(file1);
			String file1Head = file1Info[0].toLowerCase();
			String file1Number = file1Info[1];

			String[] file2Info = getHeadAndNumber(file2);
			String file2Head = file2Info[0].toLowerCase();
			String file2Number = file2Info[1];
			int i;
			
			for (i = 0; i < Math.min(file1Head.length(), file2Head.length()); i++) {
				
				if (file1Head.charAt(i) == file2Head.charAt(i))
					continue;
					
				// 더 크다 : 알파벳 순으로 더 뒤에 있다 -> 
				if (file1Head.charAt(i) < file2Head.charAt(i)) {
					return -1;
				} else {
					return 1;
				}
			}
			
			// 여기까지 오면 동일한 길이에 대한 파일 명이 같음
			if (file1Head.length() > i)
				return 1;
			
			if (file2Head.length() > i)
				return -1;
			
			// Head 부분이 같음 
			return sortByNumber(file1Number, file2Number);
		}
		
		private int sortByNumber(String file1, String file2) {
			int file1Num = Integer.parseInt(file1);
			int file2Num = Integer.parseInt(file2);
			
			return file1Num - file2Num;
		}
	}
}
 