package relationManagement;

import java.util.List;

public class ListUtilities {
/**
 * @returns true if and only if list1/2 contain the SAME elements in the SAME order
 */
	public static <T> boolean sameElements(List<T> list1, List<T> list2) {
		if(list1.size()!=list2.size()) return false;
		for (int i = 0; i < list1.size(); i++) if(list1.get(i)!=list2.get(i)) return false;
		return true;
	}
}
