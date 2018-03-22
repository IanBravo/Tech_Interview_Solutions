//CodeFights Solutions

//Arrays
//First Non Repeating Character
public static char firstNonRepeatingCharacter(String s)
{
	ArrayList<Character> values = new ArrayList<Character>();
	HashSet<Character> repeatedChars = new HashSet<Character>();
	char[] stringArray = s.toCharArray();
	    
	for (int i = 0; i < stringArray.length; i++)
	{
	    if (values.indexOf(stringArray[i])  == -1)
	    {
	        if (!repeatedChars.contains(stringArray[i]))
	            values.add(stringArray[i]);
	    }
	    else
	    {
	        repeatedChars.add(stringArray[i]);
	        values.remove(values.indexOf(stringArray[i]));
	    }
	}
	    
	if (values.size() > 0)
	    return values.get(0);
	else
	    return '_';
}

//Rotate image 90 degrees clockwise
public static void transpose(int[][] matrix)
{
	for (int i = 0; i < matrix.length; i++) 
	{
        for (int j = i; j < matrix[0].length; j++) 
        {
            int x = matrix[i][j];
           	matrix[i][j] = matrix[j][i];
            matrix[j][i] = x;
        }
    }
}
	
public static int[][] rotateImage(int[][] matrix)
{
    //  swap rows
	for (int  i = 0, k = matrix.length - 1; i < k; ++i, --k) 
	{
	    int[] x = matrix[i];
	    matrix[i] = matrix[k];
	    matrix[k] = x;
	}
	transpose(matrix);
    return matrix;
}

//Sudoku validation
boolean sudoku2(char[][] grid) 
{
    HashSet<Character> numbers = new HashSet<Character>();
    for (int i = 0; i < grid.length; i += 3)
    {
        for (int j = 0; j < grid.length; j += 3)
        {
            for(int x = i; x < i + 3; x++)
            {
                for(int y = j; y < j + 3; y++)
                {
                    if (numbers.contains(grid[x][y]))
                    {
                        return false;
                    }
                    else
                    {
                        if (grid[x][y] != '.')
                        {
                            numbers.add(grid[x][y]);
                        }
                    }
                }
            }
            numbers.clear();
        }
    }
    
    for (int i = 0; i < grid.length; i++)
    {
        for(int j = 0; j < grid[i].length; j++)
        {
            if (numbers.contains(grid[i][j]))
            {
                return false;
            }
            else
            {
                if (grid[i][j] != '.')
                {
                    numbers.add(grid[i][j]);
                }
            }
        }
        numbers.clear();
    }
    
    for (int i = 0; i < grid.length; i++)
	    {
	        for(int j = 0; j < grid[i].length; j++)
	        {
	            if (numbers.contains(grid[j][i]))
	            {
	                return false;
	            }
	            else
	            {
	                if (grid[j][i] != '.')
	                {
	                    numbers.add(grid[j][i]);
	                }
	            }
	        }
	        numbers.clear();
	    }
    return true;
}


// Remove K from Linked List
				
// Definition for singly-linked list:
// class ListNode<T> {
//   ListNode(T x) {
//     value = x;
//   }
//   T value;
//   ListNode<T> next;
// }
//
ListNode<Integer> removeKFromList(ListNode<Integer> head, int val) 
{
    while (head != null && head.value == val)
        head = head.next;
    
    ListNode<Integer> current = head;
    
    while (current != null && current.next != null)
    {
        if (current.next.value == val)
        {
            current.next = current.next.next;
        }
        else
        {
            current = current.next;
        }
    }
    return head;
}

//is List Palindrome

// Definition for singly-linked list:
// class ListNode<T> {
//   ListNode(T x) {
//     value = x;
//   }
//   T value;
//   ListNode<T> next;
// }
//
boolean isListPalindrome(ListNode<Integer> list) 
{
    if (list == null)
        return true;
    
    Stack<Integer> stack = new Stack<Integer>();
    ListNode<Integer> dummy = list;
    
    while (list != null)
    {
        stack.push(list.value);
        list = list.next;
    }
    
    while (dummy != null)
    {
        int temp = stack.pop();
        if (dummy.value != temp)
            return false;
        dummy = dummy.next;
    }
    return true;
}

//phone call
int phoneCall()
{
	if (min1 > s)
	    return 0;
	else if (min1 == s)
	    return 1;
	int minutes = 0;
	s-= min1;
	minutes++;
	    
	if (min2_10 > s)
	{
	    return minutes;
	}
	else
	{
	    int i = 1;
	    while (i < 9)
	    {
	        int temp = i * min2_10;
	        if (temp > s)
	        {
	            minutes += (i - 1);
	            s -= (i - 1) * s;
	            break;
	        }
	        i++;
	    }
	    if (minutes == 1)
	    {
	        minutes += i;
	        s -= i * min2_10;
	    }
	        
	    if (min11 > s)
	        return minutes;
	        
	    minutes += s / min11;
	}
	return minutes;
}

//Reverse Linked List
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public ListNode reverseList(ListNode head) 
{
    if (head == null)
        return head;
        
    ListNode dummy = head;
    Stack<Integer> reverseNodes = new Stack<Integer>();
        
    while (head != null)
    {
        reverseNodes.add(head.val);
        head = head.next;
    }
    head = dummy;
        
    while(!reverseNodes.empty())
    {
        dummy.val = reverseNodes.pop();
        dummy = dummy.next;
    }
    return head;
}

//find all anagrams in a string
static List<Integer> findAnagrams(String s, String p) 
{
    List<Integer> list = new ArrayList<>();
    if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;
    int[] hash = new int[256]; //character hash
    //record each character in p to hash
    for (char c : p.toCharArray()) 
    {
        hash[c]++;
    }
    //two points, initialize count to p's length
    int left = 0, right = 0, count = p.length();
    while (right < s.length()) 
    {
        //move right everytime, if the character exists in p's hash, decrease the count
        //current hash value >= 1 means the character is existing in p
        if (hash[s.charAt(right)] >= 1) 
        {
            count--;
        }
        hash[s.charAt(right)]--;
        right++;
        //when the count is down to 0, means we found the right anagram
        //then add window's left to result list
        if (count == 0) 
        {
            list.add(left);
        }
        //if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
        //++ to reset the hash because we kicked out the left
        //only increase the count if the character is in p
        //the count >= 0 indicate it was original in the hash, cuz it won't go below 0
        if (right - left == p.length()) 
        {
            if (hash[s.charAt(left)] >= 0) 
            {
                count++;
            }
            hash[s.charAt(left)]++;
            left++;
        }
    }
    return list;
}

//Linked List has cycle
public boolean hasCycle(ListNode head) 
{
    ListNode slow = head;
    ListNode fast = head;
    
    while (fast != null && fast.next != null)
    {
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast)
            break;
    }
    
    if (fast == null || fast.next == null)
        return false;
    else
        return true;
}

//Largest rectangular area in histogram
public int largestRectangleArea(int[] heights) 
{
    Stack<Integer> stack = new Stack<Integer>();
    stack.push(-1);
    int maxarea = 0;
    for (int i = 0; i < heights.length; ++i)
    {
        while (stack.peek() != -1 && heights[stack.peek()] >= heights[i])
        {
            maxarea = Math.max(maxarea, heights[stack.pop()] * (i - stack.peek() - 1));
        }                    
        stack.push(i);
    }
    int lastIndex = stack.peek();
    while (stack.peek() != -1)
    {
        maxarea = Math.max(maxarea, heights[stack.pop()] * (lastIndex - stack.peek()));
    }                
    return maxarea;
}

//HackerRank: Hourglass 
public static void largestHourglass(int[][] arr) 
{
    int largest = Integer.MIN_VALUE;
    int temp = 0;

    for (int i = 0; i < arr.length; i++) 
    {
        for (int j = 0; j < arr[i].length; j++) 
        {
            temp += arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1] + arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];

            if (temp > largest)
                largest = temp;

            if (j >= 3)
                break;
            temp = 0;
        }
        if (i >= 3)
            break;
        temp = 0;
    }
    System.out.println(Integer.toString(largest));
}

//HackerRank Array LeftRotation
static int[] leftRotation(int[] arr, int d) 
{
    int leftRot = 0;
    for(int i = 0; i < d; i++)
    {
        leftRot = arr[0];
        for (int j = 0; j < arr.length - 1; j++)
        {
            arr[j] = arr[j + 1];
        }
        arr[arr.length - 1] = leftRot;
    }
    return arr;
}

//HackerRank Inserting a Node Into a Sorted Doubly Linked List
Node SortedInsert(Node head,int data) 
{
    if (head.next == null)
    {
	   Node newNode = new Node();
	   newNode.data = data;
       newNode.prev = head;
       head.next = newNode;
       return head;
    }
    
    Node dummy = head.next;
    Node newNode = new Node();
	newNode.data = data;
	
	while(dummy != null)
	{
		if (data < dummy.data && dummy.next == null)
		{
			dummy.prev.next = newNode;
			newNode.next = dummy;
			newNode.prev = dummy.prev;
			dummy.next = null;
			dummy.prev = newNode;
			break;
		}
		else if (data > dummy.data && dummy.next == null)
		{
			dummy.next = newNode;
			newNode.prev = dummy;
			break;
		}
		else if (data > dummy.data && data < dummy.next.data)	        
        {
			newNode.next = dummy.next;
			dummy.next.prev = newNode;
            dummy.next = newNode;       
            break;
        }
        dummy = dummy.next;
    }
    return head;
}

//IsCryptSolution
static boolean isCryptSolution(String[] crypt, char[][] solution) 
{   
    Map<Character, Character> key = new HashMap<Character, Character>();
    int word1 = 0;
    int word2 = 0;
    int word3 = 0;
    char[] result = crypt[2].toCharArray();
    
    for(int i = 0; i < solution.length; i++)
    {
       key.put(solution[i][0], solution[i][1]); 
    }
    
    for(int i = 0; i < crypt.length - 1; i++)
    {
        char[] word = crypt[i].toCharArray();
        
        if(word.length > 1)
        {
            if (key.get(word[0]) == '0')
                return false;
            if (i == 0)
            	word1 = getCode(word, key);
            else
            	word2 = getCode(word, key);
        }
        else
        {
            if (i == 0)
                word1 = Character.getNumericValue(key.get(word[0]));
            else
                word2 = Character.getNumericValue(key.get(word[0]));
        }
    }
    
    int res = word1 + word2;
    
    if (result.length > 1)
    {
    	if (key.get(result[0]) == '0')
            return false;
        word3 = getCode(result, key);
        if (word3 == res)
            return true;
        else
            return false;
    }
    else
    {
        word3 = Character.getNumericValue(key.get(result[0]));
        if (word3 == res)
            return true;
        else
            return false;
    }
}

static int getCode(char[] word, Map<Character, Character> key)
{
	int tens = 1;
    int code = 0;
    for(int i = word.length - 1; i >= 0; i--)
    {
        code += (Character.getNumericValue(key.get(word[i])) * tens);
        tens *= 10;
    }
    return code;
}


public static Integer[] commonElements(int[] array1, int[] array2) 
{
    ArrayList<Integer> common = new ArrayList<Integer>();
    int p1 = 0, p2 = 0;

    while (p1 < array1.length && p2 < array2.length)
    {
    	if (array1[p1] == array2[p2])
    	{
    		common.add(array1[i]);
    		p1++;
    		p2++;
    	}
    	else if (array1[p1] > array2[p2])
    		p2++;
    	else
    		p1++;
    }
    return common.toArray(new Integer[common.size()]);
}

public static Boolean isRotation(int array1[], int array2[])
{
	if (array1.length != array2.length)
		return false;

	int key = array1[0], key_i = -1;

	for (int i = 0; i < array2.length; i++)
	{
		if (array2[i] == key)
		{
			key_i = i;
			break;
		}
	}

	if (key_i == -1)
		return false;

	for (int i = 0; i < array1.length; i++)
	{
		int j = (key_i + i) % array1.length;
		if (array1[i] != array2[j])
			return false;
	}
	return true;
}

public List<Integer> findDuplicates(int[] nums) 
{
    HashSet<Integer> hash = new HashSet<Integer>();
    ArrayList<Integer> duplicates = new ArrayList<Integer>();
    
    for (int i = 0; i < nums.length; i++)
    {
        if (hash.contains(nums[i]))
            duplicates.add(nums[i]);
        else
            hash.add(nums[i]);
    }
    return duplicates;
}



public static int[] mergeArrays(int[] A, int[] B) 
 {
    if (A.length == 0)
        return B;
    else if (B.length == 0)
        return A;
    
    int p1 = 0, p2 = 0, p3 = 0;
    int[] merge = new int[A.length + B.length];
    
    while(p1 < A.length && p2 < B.length)
    {
        if (A[p1] < B[p2])
        {
            merge[p3] = A[p1];
            p1++;
            p3++;
        }
        else if (A[p1] == B[p2])
        {
            merge[p3] = A[p1];
            p1++;
            p3++;
            
            merge[p3] = B[p2];
            p2++;
            p3++;
        }
        else
        {
            merge[p3] = B[p2];
            p2++;
            p3++;
        }
    }
    
    if (p1 != A.length)
    {
        while (p1 < A.length)
        {
            merge[p3] = A[p1];
            p1++;
            p3++;
        }
    }
    
    if (p2 != B.length)
    {
        while (p2 < B.length)
        {
            merge[p3] = B[p2];
            p2++;
            p3++;
        }
    }
    
    return merge;
}

static ListNode<Integer> mergeTwoLinkedLists(ListNode<Integer> l1, ListNode<Integer> l2) 
{
    if (l1 == null)
        return l2;
    if (l2 == null)
        return l1;
    
    ListNode<Integer> head = new ListNode<Integer>(0);
    ListNode<Integer> dummy = null;
    
    if (l1.value > l2.value)
    {
        head.value = l2.value;
        dummy = head;
        l2 = l2.next;
    }
    else if (l1.value < l2.value)
    {
        head.value = l1.value;
        dummy = head;
        l1 = l1.next;
    }
    else
    {
        head.value = l1.value;
        head.next = new ListNode<Integer>(l2.value);
        dummy = head.next;
        l1 = l1.next;
        l2 = l2.next;
    }
    
    while (l1 != null && l2 != null)
    {
        if (l1.value > l2.value)
        {
            dummy.next = new ListNode<Integer>(l2.value);
            dummy = dummy.next;
            l2 = l2.next;
        }
        else if (l1.value < l2.value)
        {
            dummy.next = new ListNode<Integer>(l1.value);
            dummy = dummy.next;
            l1 = l1.next;
        }
        else
        {
            dummy.next = new ListNode<Integer>(l1.value);
            dummy = dummy.next;
            dummy.next = new ListNode<Integer>(l2.value);
            dummy = dummy.next;
            l1 = l1.next;
            l2 = l2.next;
        }
    }
    
    if (l1 == null)
    {
        while (l2 != null)
        {
            dummy.next = new ListNode<Integer>(l2.value);
            dummy = dummy.next;
            l2 = l2.next;
        }
    }
    
    if (l2 == null)
    {
        while (l1 != null)
        {
            dummy.next = new ListNode<Integer>(l1.value);
            dummy = dummy.next;
            l1 = l1.next;
        }
    }
    
    return head;
}

static String compression(String str)
{
	if (str.length() == 0)
		return str;
	
	StringBuilder sb = new StringBuilder();
	int count = 1;
	char[] chars = str.toCharArray();
	char current = chars[0];
	
	for (int i = 1; i< chars.length; i++) {
		if (chars[i] != current) {
			sb.append(current);
			sb.append(count);
			count = 1;
			current = chars[i];
		} else {
			count++;
		}
	}
	
	if (count > 0) {
		sb.append(current);
		sb.append(count);
	}
	
	if (sb.toString().length() >= str.length())
		return str;
	else
		return sb.toString();
}

public ListNode deleteDuplicates(ListNode head) 
{
    if (head == null)
        return head;
    
    HashMap<Integer, Integer> duplicates = new HashMap<Integer, Integer>();
    
    ListNode dummy = head;
    ListNode trimmed = new ListNode(0);
    ListNode builder = trimmed;
    
    while (dummy != null)
    {
        if (duplicates.containsKey(dummy.val))
        {
            int count = duplicates.get(dummy.val);
            duplicates.put(dummy.val, ++count);
        }
        else
        {
            duplicates.put(dummy.val, 1);
        }
        dummy = dummy.next;
    }
    dummy = head;
    
    while (dummy != null)
    {
        if (duplicates.get(dummy.val) == 1)
        {
            builder.next = new ListNode(dummy.val);
            builder = builder.next;
        }
        dummy = dummy.next;
    }
    return trimmed.next;
}

public static ListNode partition(ListNode head, int x) 
{
    if (head == null)
        return head;
    
    ListNode less = new ListNode(0);
    ListNode res = less;
    ListNode greater = new ListNode(0);
    ListNode begGreater = greater;
    
    while (head != null)
    {
        if (head.val < x)
        {
            less.next = new ListNode(head.val);
            less = less.next;
        }
        else
        {
            greater.next = new ListNode(head.val);
            greater = greater.next;
        }
        head = head.next;
    }
    
    less.next = begGreater.next;;
    return res.next;
}

static ListNode getIntersectionNode(ListNode headA, ListNode headB) 
{
    if (headA == null || headB == null)
        return null;
    
    ListNode dummyA = headA, dummyB = headB;
    ListNode endA = null;
    ListNode endB = null;
    boolean finishedA = false, finishedB = false;
    
    while (true)
    {
        if (endA != null && endB != null)
        {
            if (endA.val != endB.val)
                return null;
        }
                                                      
        if (dummyA == null)
        {
            if (!finishedA)
            {
                finishedA = true;
                dummyA = headB;
            }
            else
            {
                finishedA = false;
                dummyA = headA;
            }
        }
        
        if (dummyB == null)
        {                
            if (!finishedB)
            {
                finishedB = true;
                dummyB= headA;
            }
            else
            {
                finishedB = false;
                dummyB = headB;
            }
        }
        
        if (dummyA.next == null)
        	if (endA == null)
                endA = dummyA;
        
        if (dummyB.next == null)
        	if (endB == null)
                endB = dummyB;
        
        if (dummyA.val == dummyB.val)
            return dummyA;
        
        dummyA = dummyA.next;
        dummyB = dummyB.next;
    }
}

///////// Paths SUM

static List<List<Integer>> pathSum(TreeNode root, int sum) 
{
    if (root == null) return null;
    
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    pathSumHelper(root, sum, res, new ArrayList<Integer>());
    
    return res;
}

static void pathSumHelper(TreeNode root, int sum, List<List<Integer>> res, List<Integer> path)
{
	if (root == null) return;
	
    path.add(new Integer(root.val));
    
    if (root.left == null && root.right == null && sum == root.val)
    {        	
        res.add(new ArrayList<Integer>(path));
        path.remove(path.size() - 1);
        return;
    }
    else
    {
    	pathSumHelper(root.left, sum - root.val, res, path);
    	pathSumHelper(root.right, sum - root.val, res, path);
    }
    
    path.remove(path.size() - 1);
}
////////

private TreeNode sortedArray(int[] nums, int start, int end)
{
    if (start > end)
        return null;
    
    int mid = (start + end) / 2;
    TreeNode node = new TreeNode(nums[mid]);
    node.left = sortedArray(nums, start, mid - 1);
    node.right = sortedArray(nums, mid + 1, end);
    return node;
}

///////////////

static boolean twoSum(TreeNode root, int sum, HashSet<Integer> hash) 
{
	if (root == null) return false;
	
	if (hash.contains(sum - root.val)) return true;
	
	if (!hash.contains(root.val)) hash.add(root.val);
	
	return twoSum(root.left, sum, hash) || twoSum(root.right, sum, hash);
}

//////////////////

public class Codec 
{

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) 
    {
        StringBuilder str = new StringBuilder();
        serialize(root, str);
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) 
    {
        return deseiralizehelper(new StringBuilder(data));
    }
    
    private TreeNode deseiralizehelper(StringBuilder tree) {
        if(tree.length() == 0) return null;
        if(tree.charAt(0) == '#') 
        {
            tree.deleteCharAt(0);
            tree.deleteCharAt(0);
            return null;
        }
        
        int comma = 0;
        while(tree.charAt(comma) != ',') comma++;
        
        int value = Integer.parseInt(tree.substring(0, comma));
        TreeNode root = new TreeNode(value);
        tree.delete(0, comma + 1);
        root.left = deseiralizehelper(tree);
        root.right = deseiralizehelper(tree);
        return root;
    }
    
    private static void serialize(TreeNode root, StringBuilder str)
    {
        if (root == null)
        {
            str.append("#");
            str.append(",");
            return;
        }
        str.append(root.val);
        str.append(",");
        serialize(root.left, str);
        serialize(root.right, str);
    }
}

/////////////////////////// Binary Tree Level Order traversal

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) 
    {
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
		for(int i = 1; i <= height(root); i++)
		{
			levels.add(level(root, i, new ArrayList<Integer>()));
		}
		
		return levels;
    }
    
    private List<Integer> level(TreeNode root, int level, List<Integer> levelList)
	{
		if (root == null) return null;
		
		if (level == 1)
		{
			levelList.add(root.val);
		}
		else if (level > 1)
		{
			level(root.left, level - 1, levelList);
			level(root.right, level - 1, levelList);
		}
		
		return levelList;
		
	}
    
    private int height(TreeNode root) 
    {
        if (root == null)
            return 0;
        
        int leftDepth = height(root.left);
        int rightDepth = height(root.right);
        
        return 1 + Math.max(leftDepth, rightDepth);
    }
}

/////////////// is binary tree symmetric
class Solution {
    public boolean isSymmetric(TreeNode root) 
    {
        return symmetric(root, root);
    }
    
    private boolean symmetric(TreeNode r1, TreeNode r2)
    {
        if (r1 == null && r2 == null) return true;
        
        if (r1 == null || r2 == null || r1.val != r2.val) return false;
        
        return symmetric(r1.left, r2.right) && symmetric(r1.right, r2.left);
    }
}

////////////// swap nodes in pairs Linked List

public ListNode swapPairs(ListNode head) 
{
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode p = head, prev = dummy;
    
    while (p != null && p.next != null)
    {
        ListNode q = p.next, r = p.next.next;
        prev.next = q;
        q.next = p;
        p.next = r;
        prev = p;
        p = r;
    }
    return dummy.next;
}

/////////////// merge trees
public TreeNode mergeTrees(TreeNode t1, TreeNode t2) 
{
    if (t1 == null && t2 == null) return null;
    
    if (t1 != null && t2 == null) return t1;
    
    if (t1 == null && t2 != null) return t2;
    
    t1.val += t2.val;
    
    t1.left = mergeTrees(t1.left, t2.left);
    t1.right = mergeTrees(t1.right, t2.right);
    
    return t1;
}

/////////////////// BST iterator

public class BSTIterator 
{
    int index;
    List<Integer> tree;
    public BSTIterator(TreeNode root) 
    {
        this.tree = new ArrayList<Integer>();
        inOrderArray(root, tree);
        this.index = 0;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() 
    {
        if (this.index < this.tree.size())
            return true;
        else
            return false;
    }

    /** @return the next smallest number */
    public int next() 
    {
        if (this.hasNext())
        {
            int temp = this.tree.get(this.index);
            this.index++;
            return temp;
        }
        else
        {
            return this.tree.get(this.index);
        }
    }

    private void inOrderArray(TreeNode root, List<Integer> list)
    {
        if (root == null) return;

        inOrderArray(root.left, list);
        list.add(root.val);
        inOrderArray(root.right, list);
    }
}

/////////////////// Binary Tree In Order Traversal

public List<Integer> inorderTraversal(TreeNode root) 
{
    List<Integer> res = new ArrayList<Integer>();
    inorderTraversal(root, res);
    return res;
}

private void inorderTraversal(TreeNode root, List<Integer> list)
{
    if (root == null) return;

    inorderTraversal(root.left, list);
    list.add(root.val);
    inorderTraversal(root.right, list);
}

/////////////////// Binary Tree Post Order Traversal

public List<Integer> postorderTraversal(TreeNode root) 
{
    List<Integer> res = new ArrayList<Integer>();
    postorderTraversal(root, res);
    return res;
}

private void postorderTraversal(TreeNode root, List<Integer> list)
{
    if (root == null) return;

    postorderTraversal(root.left, list);        
    postorderTraversal(root.right, list);
    list.add(root.val);
}


////////////////// Binary Tree Pre Order Traversal

public List<Integer> preorderTraversal(TreeNode root) 
{
    List<Integer> res = new ArrayList<Integer>();
    preorderTraversal(root, res);
    return res;
}

private void preorderTraversal(TreeNode root, List<Integer> list)
{
    if (root == null) return;
    
    list.add(root.val);
    preorderTraversal(root.left, list);        
    preorderTraversal(root.right, list);        
}

/////////////////// Populating Next Right Pointers in Each Node

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution 
{
    public void connect(TreeLinkNode root) 
    {
        if (root == null) return;
        
        Queue<TreeLinkNode> queue = new ArrayDeque<TreeLinkNode>();
        queue.add(root);
        double nodesInLevel = 1;
        double level = 0;
        double count = 1;
        
        while(!queue.isEmpty())
        {
            TreeLinkNode curr = queue.poll();
            
            if (count < nodesInLevel)
            {
                TreeLinkNode temp = queue.peek();
                curr.next = temp;
                count++;
            }
            else
            {
                count = 1;
                level++;
                nodesInLevel = Math.pow(2, level);
            }
            
            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);
        }
    }
}

////////////////////// Kth Smallest Element in a BST

class Solution 
{
    int count = 0;
    int result = Integer.MIN_VALUE;
    
    public int kthSmallest(TreeNode root, int k) 
    {
        kth(root, k);
        return result;
    }
    
    private void kth(TreeNode root, int k)
    {
        if (root == null) return;
    
        kth(root.left, k);
        count++;
        if (count == k) result = root.val;
        kth(root.right, k);
    }
}

////////////////////// Best Time to Buy and Sell Stock

public int maxProfit(int[] prices) 
{
    if (prices.length == 0)
        return 0;
    
    int minPrice = prices[0];
    int maxProfit = 0;
    
    for (int currentPrice : prices)
    {
        minPrice = Math.min(minPrice, currentPrice);
        
        int potentialProfit = currentPrice - minPrice;
        maxProfit = Math.max(maxProfit, potentialProfit);
    }
    return maxProfit;
}

//////////////////// Product of Array Except Self

public int[] productExceptSelf(int[] intArray) 
{
    int[] productsOfAllIntsExceptAtIndex = new int[intArray.length];
    if (intArray.length < 2) 
    {
        return productsOfAllIntsExceptAtIndex;
    }

    int productSoFar = 1;
    for (int i = 0; i < intArray.length; i++) 
    {
        productsOfAllIntsExceptAtIndex[i] = productSoFar;
        productSoFar *= intArray[i];
    }

    productSoFar = 1;
    for (int i = intArray.length - 1; i >= 0; i--) 
    {
        productsOfAllIntsExceptAtIndex[i] *= productSoFar;
        productSoFar *= intArray[i];
    }

    return productsOfAllIntsExceptAtIndex;
}

////////////////// Maximum Product of Three Numbers

public int maximumProduct(int[] arrayOfInts) 
{
    int highest = Math.max(arrayOfInts[0], arrayOfInts[1]);
    int lowest  = Math.min(arrayOfInts[0], arrayOfInts[1]);

    int highestProductOf2 = arrayOfInts[0] * arrayOfInts[1];
    int lowestProductOf2  = arrayOfInts[0] * arrayOfInts[1];

    int highestProductOf3 = arrayOfInts[0] * arrayOfInts[1] * arrayOfInts[2];

    for (int i = 2; i < arrayOfInts.length; i++) 
    {
        int current = arrayOfInts[i];

        highestProductOf3 = Math.max(Math.max(
            highestProductOf3,
            current * highestProductOf2),
            current * lowestProductOf2);

        highestProductOf2 = Math.max(Math.max(
            highestProductOf2,
            current * highest),
            current * lowest);

        lowestProductOf2 = Math.min(Math.min(
            lowestProductOf2,
            current * highest),
            current * lowest);

        highest = Math.max(highest, current);

        lowest = Math.min(lowest, current);
    }

    return highestProductOf3;
}

/////////////// Palindrome Permutation

public boolean canPermutePalindrome(String s) 
{
    HashSet<Character> unpairedChars = new HashSet<>();
    
    for (char c : s.toCharArray())
    {
        if (unpairedChars.contains(c))
            unpairedChars.remove(c);
        else
            unpairedChars.add(c);
    }
    
    return unpairedChars.size() <= 1;
}


//////////////// Longest Substring Without Repeating Characters

public int lengthOfLongestSubstring(String str) 
{
    if (str.length() == 0)
        return 0;
    
    int maxSub = 0;
    StringBuilder sb = new StringBuilder();
    HashSet<Character> hash = new HashSet<>();
    
    for (char c : str.toCharArray())
    {
        if (hash.contains(c))
        {
            maxSub = Math.max(maxSub, sb.length());
            hash.clear();
            sb.delete(0, sb.length());
            hash.add(c);
            sb.append(c);
        }
        else
        {
            hash.add(c);
            sb.append(c);
        }
    }
    
    return Math.max(maxSub, sb.length());
}

//////////////////// Reverse Words in a String

public String reverseWords(String s) 
{
    if (s.length() == 0) return s;
    
    Stack<String> words = new Stack<>();
    StringBuilder word = new StringBuilder();
    
    for (int i = 0; i < s.length(); i++)
    {
        if (s.charAt(i) == ' ')
        {
            if (word.length() > 0)
            {
                words.push(word.toString());
                word.delete(0, word.length());
            }
        }
        else
        {
            word.append(s.charAt(i));
        }
    }
    
    if (word.length() > 0)
    {
        words.push(word.toString());
        word.delete(0, word.length());
    }
    
    while(!words.isEmpty())
    {
        word.append(words.pop());
        word.append(" ");
    }
    
    if (word.length() > 0)
        word.delete(word.length() - 1, word.length());
    
    return word.toString();
}

//////////////////// Longest Valid Parentheses

public int longestValidParentheses(String s) 
{
    int max = 0;
    Stack<Integer> stack = new Stack<>();
    stack.push(-1);
    for (int i = 0; i < s.length(); i++) 
    {
        if (s.charAt(i) == '(') 
        {
            stack.push(i);
        } 
        else 
        {
            stack.pop();
            if (stack.empty()) 
            {
                stack.push(i);
            } 
            else 
            {
                max = Math.max(max, i - stack.peek());
            }
        }
    }
    return max;
}

/////////////////// One Edit Distance

public boolean isOneEditDistance(String s, String t) 
{
    int m = s.length(), n = t.length();
    if (m > n) return isOneEditDistance(t, s);
    if (n - m > 1) return false;
    int i = 0, shift = n - m;
    while (i < m && s.charAt(i) == t.charAt(i)) i++;
    if (i == m) return shift > 0;
    if (shift == 0) i++;
    while (i < m && s.charAt(i) == t.charAt(i + shift)) i++;
    return i == m;
}