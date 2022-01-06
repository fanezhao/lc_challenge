  /**
<p>罗马数字包含以下七种字符:&nbsp;<code>I</code>，&nbsp;<code>V</code>，&nbsp;<code>X</code>，&nbsp;<code>L</code>，<code>C</code>，<code>D</code>&nbsp;和&nbsp;<code>M</code>。</p>

<pre>
<strong>字符</strong>          <strong>数值</strong>
I             1
V             5
X             10
L             50
C             100
D             500
M             1000</pre>

<p>例如， 罗马数字 <code>2</code> 写做&nbsp;<code>II</code>&nbsp;，即为两个并列的 1 。<code>12</code> 写做&nbsp;<code>XII</code>&nbsp;，即为&nbsp;<code>X</code>&nbsp;+&nbsp;<code>II</code>&nbsp;。 <code>27</code> 写做&nbsp;&nbsp;<code>XXVII</code>, 即为&nbsp;<code>XX</code>&nbsp;+&nbsp;<code>V</code>&nbsp;+&nbsp;<code>II</code>&nbsp;。</p>

<p>通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做&nbsp;<code>IIII</code>，而是&nbsp;<code>IV</code>。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为&nbsp;<code>IX</code>。这个特殊的规则只适用于以下六种情况：</p>

<ul>
	<li><code>I</code>&nbsp;可以放在&nbsp;<code>V</code>&nbsp;(5) 和&nbsp;<code>X</code>&nbsp;(10) 的左边，来表示 4 和 9。</li>
	<li><code>X</code>&nbsp;可以放在&nbsp;<code>L</code>&nbsp;(50) 和&nbsp;<code>C</code>&nbsp;(100) 的左边，来表示 40 和&nbsp;90。&nbsp;</li>
	<li><code>C</code>&nbsp;可以放在&nbsp;<code>D</code>&nbsp;(500) 和&nbsp;<code>M</code>&nbsp;(1000) 的左边，来表示&nbsp;400 和&nbsp;900。</li>
</ul>

<p>给定一个罗马数字，将其转换成整数。</p>

<p>&nbsp;</p>

<p><strong>示例&nbsp;1:</strong></p>

<pre>
<strong>输入:</strong>&nbsp;s = "III"
<strong>输出:</strong> 3</pre>

<p><strong>示例&nbsp;2:</strong></p>

<pre>
<strong>输入:</strong>&nbsp;s = "IV"
<strong>输出:</strong> 4</pre>

<p><strong>示例&nbsp;3:</strong></p>

<pre>
<strong>输入:</strong>&nbsp;s = "IX"
<strong>输出:</strong> 9</pre>

<p><strong>示例&nbsp;4:</strong></p>

<pre>
<strong>输入:</strong>&nbsp;s = "LVIII"
<strong>输出:</strong> 58
<strong>解释:</strong> L = 50, V= 5, III = 3.
</pre>

<p><strong>示例&nbsp;5:</strong></p>

<pre>
<strong>输入:</strong>&nbsp;s = "MCMXCIV"
<strong>输出:</strong> 1994
<strong>解释:</strong> M = 1000, CM = 900, XC = 90, IV = 4.</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 15</code></li>
	<li><code>s</code> 仅含字符 <code>('I', 'V', 'X', 'L', 'C', 'D', 'M')</code></li>
	<li>题目数据保证 <code>s</code> 是一个有效的罗马数字，且表示整数在范围 <code>[1, 3999]</code> 内</li>
	<li>题目所给测试用例皆符合罗马数字书写规则，不会出现跨位等情况。</li>
	<li>IL 和 IM 这样的例子并不符合题目要求，49 应该写作 XLIX，999 应该写作 CMXCIX 。</li>
	<li>关于罗马数字的详尽书写规则，可以参考 <a href="https://b2b.partcommunity.com/community/knowledge/zh_CN/detail/10753/%E7%BD%97%E9%A9%AC%E6%95%B0%E5%AD%97#knowledge_article">罗马数字 - Mathematics </a>。</li>
</ul>
<div><div>Related Topics</div><div><li>哈希表</li><li>数学</li><li>字符串</li></div></div><br><div><li>👍 1641</li><li>👎 0</li></div>
*/

package com.zmoyi.leetcode.editor.cn;

  import java.util.HashMap;
  import java.util.Map;

  public class Q13RomanToInteger {
  public static void main(String[] args) {
      Solution solution = new Q13RomanToInteger().new Solution();
	  System.out.println(solution.romanToInt("I"));
	  System.out.println(solution.romanToInt("LXXX"));
	  System.out.println(solution.romanToInt("MMMCCCXXXIII"));
	  System.out.println(solution.romanToInt("MCDXXXVII"));
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

	  Map<Character, Integer> symbolVal = new HashMap<>() {
		  {
			  put('I', 1);
			  put('V', 5);
			  put('X', 10);
			  put('L', 50);
			  put('C', 100);
			  put('D', 500);
			  put('M', 1000);
		  }
	  };

	  /**
	   * 官方思路
	   *
	   * 通常情况下，罗马数字中小的数字在大的数字的右边。若输入的字符串满足该情况，那么可以将每个字符视作一个单独的值，累加每个字符对应的数值即可。
	   *
	   * 例如 XXVII 可视作 X+X+V+I+I=10+10+5+1+1=27。
	   *
	   * 若存在小的数字在大的数字的左边的情况，根据规则需要减去小的数字。对于这种情况，我们也可以将每个字符视作一个单独的值，若一个数字右侧的数字比它大，则将该数字的符号取反。
	   *
	   * 例如 XIV 可视作 X−I+V=10−1+5=14。
	   * @param s
	   * @return
	   */
	  public int romanToInt(String s) {
		  int result = 0;
		  for (int i = 0; i < s.length(); i++) {
			  Integer value = symbolVal.get(s.charAt(i));
			  // i < s.length() - 1，如果是最后一个字符，不用判断右边字符，直接加上即可
			  if (i < s.length() - 1 && value < symbolVal.get(s.charAt(i + 1))) {
				  result -= value;
			  } else {
				  result += value;
			  }
		  }
		  return result;
	  }

	  /**
	   * 个人思路：
	   * 罗马数字总结就是有这下面这几种特殊的字段，过滤掉这几种特殊字符后，
	   * 剩下的字段均是单个字符，累加即可。
	   * @param s
	   * @return
	   */
      public int romanToInt1(String s) {

		  Map<String, Integer> specialMap = new HashMap<>();
		  specialMap.put("IV", 4);
		  specialMap.put("IX", 9);
		  specialMap.put("XL", 40);
		  specialMap.put("XC", 90);
		  specialMap.put("CD", 400);
		  specialMap.put("CM", 900);

		  Map<String, Integer> normalMap = new HashMap<>();
		  normalMap.put("I", 1);
		  normalMap.put("V", 5);
		  normalMap.put("X", 10);
		  normalMap.put("L", 50);
		  normalMap.put("C", 100);
		  normalMap.put("D", 500);
		  normalMap.put("M", 1000);

		  int result = 0;
		  for (Map.Entry<String, Integer> e : specialMap.entrySet()) {
			  if (s.contains(e.getKey())) {
				  result += e.getValue();
				  s = s.replace(e.getKey(), "");
			  }
		  }

		  // while (s.length() > 0) {
			//   for (Map.Entry<String, Integer> e : normalMap.entrySet()) {
			// 	  if (s.contains(e.getKey())) {
			// 		  result += e.getValue();
			// 		  s = s.replaceFirst(e.getKey(), "");
			// 	  }
			//   }
		  // }

		  for (int i = 0; i < s.length(); i++) {
			  result += normalMap.get(String.valueOf(s.charAt(i)));
		  }
		  return result;
	  }
  }
//leetcode submit region end(Prohibit modification and deletion)

}