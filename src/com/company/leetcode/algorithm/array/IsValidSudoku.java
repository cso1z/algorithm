package com.company.leetcode.algorithm.array;

import com.company.leetcode.interfac.AlgorithmInterface;
import com.company.leetcode.utils.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LC 有效的数独
 * 请你判断一个9x9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 * 数字1-9在每一行只能出现一次。
 * 数字1-9在每一列只能出现一次。
 * 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用'1'表示。
 * 注意：
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * URl：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2f9gg/
 * time:2021-04-16
 */
public class IsValidSudoku implements AlgorithmInterface {

    @Override
    public void initData() {
        Log.oln("LC 有效的数独:" + getClass().getSimpleName());
        char[][] board = {{'8', '3', '1', '1', '7', '1', '1', '1', '1'}
                , {'6', '1', '1', '1', '9', '5', '1', '1', '1'}
                , {'1', '9', '8', '1', '1', '1', '1', '6', '1'}
                , {'8', '1', '1', '1', '6', '1', '1', '1', '3'}
                , {'4', '1', '1', '8', '1', '3', '1', '1', '1'}
                , {'7', '1', '1', '1', '2', '1', '1', '1', '6'}
                , {'1', '6', '1', '1', '1', '1', '2', '8', '1'}
                , {'1', '1', '1', '4', '1', '9', '1', '1', '5'}
                , {'1', '1', '1', '1', '8', '1', '1', '7', '9'}};
        Log.oln("result:" + isValidSudoku(board));
        Log.oln("\n");
    }

    private BoardValue[] list;

    public boolean isValidSudoku(char[][] board) {
        list = new BoardValue[27];
        for (int i = 0; i < list.length; i++) {
            list[i] = new BoardValue();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int value = 0x1 << (board[i][j] - 1);
                    if (!addValue(i, value)) {
                        return false;
                    }
                    if (!addValue(9 + j, value)) {
                        return false;
                    }
                    int index = 18 + i / 3 * 3 + j / 3;
                    if (!addValue(index, value)) {
                        return false;
                    }
                }
            }
        }
        for (int i = 0; i < list.length; i++) {
            if (!list[i].isEqual()) {
                return false;
            }
        }
        return true;
    }

    private boolean addValue(int index, int value) {
        BoardValue temp = list[index];
        temp.normalValue += value;
        temp.eorValue ^= value;
        return temp.isEqual();
    }


    public static class BoardValue {
        private final int defaultValue = 0x1 << 9;
        int normalValue = defaultValue;
        int eorValue = defaultValue;

        public BoardValue() {

        }

        public boolean isEqual() {
            return normalValue == eorValue;
        }
    }

}
