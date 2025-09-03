import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public static class Point {
        final long x, y;

        Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    // 두 직선의 교점을 구하는 함수
    private Point intersection(long a1, long b1, long c1, long a2, long b2, long c2) {
        long denominator = a1 * b2 - b1 * a2;
        if (denominator == 0) return null; // 평행 또는 일치 → 교점 없음

        double x = (double) (b1 * c2 - c1 * b2) / denominator;
        double y = (double) (c1 * a2 - a1 * c2) / denominator;

        // 정수 좌표만 반환
        if (x % 1 != 0 || y % 1 != 0) return null;
        return new Point((long) x, (long) y);
    }

    // 최소 좌표 찾기
    private Point getMinPoint(List<Point> points) {
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;   // ✅ 수정
        for (Point p : points) {
            if (p.x < x) x = p.x;
            if (p.y < y) y = p.y;
        }
        return new Point(x, y);
    }

    // 최대 좌표 찾기
    private Point getMaxPoint(List<Point> points) {
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;   // ✅ 수정
        for (Point p : points) {
            if (p.x > x) x = p.x;
            if (p.y > y) y = p.y;
        }
        return new Point(x, y);
    }

    public String[] solution(int[][] line) {
        List<Point> points = new ArrayList<>();

        // 모든 직선 쌍에 대해 교점 구하기
        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                Point intersection = intersection(
                        line[i][0], line[i][1], line[i][2],
                        line[j][0], line[j][1], line[j][2]
                );
                if (intersection != null) points.add(intersection);
            }
        }

        Point minimum = getMinPoint(points);
        Point maximum = getMaxPoint(points);

        int width = (int) (maximum.x - minimum.x + 1);   // ✅ +1
        int height = (int) (maximum.y - minimum.y + 1);  // ✅ +1

        char[][] arr = new char[height][width];
        for (char[] row : arr) {
            Arrays.fill(row, '.');
        }

        // 교점 찍기
        for (Point p : points) {
            int x = (int) (p.x - minimum.x);
            int y = (int) (maximum.y - p.y); // ✅ y좌표 반전
            arr[y][x] = '*';
        }

        // 결과를 문자열 배열로 변환
        String[] result = new String[height];
        for (int i = 0; i < height; i++) {
            result[i] = new String(arr[i]);
        }
        return result;
    }
}
