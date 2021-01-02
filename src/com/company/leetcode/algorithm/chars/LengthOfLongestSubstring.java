package com.company.leetcode.algorithm.chars;

import com.company.leetcode.interfac.AlgorithmInterface;
import com.company.leetcode.utils.Log;

import java.util.HashMap;

/**
 * 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * time:2021-01-03
 */
public class LengthOfLongestSubstring implements AlgorithmInterface {
    @Override
    public void initData() {
        Log.oln("无重复字符的最长子串：" + getClass().getSimpleName());
        String str = "abcdabda";
        Log.oln("数据：" + str);
        int length = lengthOfLongestSubstring(str);
        Log.oln("result:" + length);
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }


}
