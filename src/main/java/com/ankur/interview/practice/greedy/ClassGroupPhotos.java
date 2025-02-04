package com.ankur.interview.practice.greedy;

import java.util.ArrayList;
import java.util.Collections;

/*
/ given two equal list find if all in front row are smaller then ones in back row

 */
public class ClassGroupPhotos {
  public static boolean arrangeStudents(ArrayList<Integer> redShirtHeights,
                                        ArrayList<Integer> blueShirtHeights) {
    Collections.sort(redShirtHeights, Collections.reverseOrder());
    Collections.sort(blueShirtHeights, Collections.reverseOrder());
    String shorterList = redShirtHeights.get(0) < blueShirtHeights.get(0) ? "RED" : "GREEN";
    for (int i = 0; i < redShirtHeights.size(); i++) {
      int redShirtSize = redShirtHeights.get(i);
      int blueShirtSize = blueShirtHeights.get(i);
      if ("RED".equals(shorterList)) {
        if (redShirtSize >= blueShirtSize) {
          return false;
        }
      } else {
        if (blueShirtSize >= redShirtSize) {
          return false;
        }
      }
    }
    return true;
  }
}
