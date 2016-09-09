package seattle.algostar.ps.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Problem352_JW {
	public static void main(String[] args) {
		new Problem352_JW().solve();
	}

	private void solve() {
		SummaryRanges r = new SummaryRanges();
//		int[] A = {1, 5, 6, 7, 8, 6, 2};
//		int[] A = {6, 6, 0, 4, 8, 7, 6, 4, 7, 5};
		int[] A = {0, 1, 2, 3, 4, 5, 4};
		for (int n : A) {
			r.addNum(n);
			System.out.println(r.getIntervals());
		}
	}

	public class SummaryRanges {

		private List<Interval> intervals;

		public SummaryRanges() {
			intervals = new LinkedList<Interval>();
		}

		public void addNum(int val) {
			// 1. 이분탐색을 통해 삽입될 위치를 찾음
			Interval newInterval = new Interval(val, val);

			int ix = Collections.binarySearch(intervals, newInterval, new Comparator<Interval>() {
				@Override
				public int compare(Interval o1, Interval o2) {
					return o1.end - o2.end;
				}
			});

			if (ix >= 0) {
				return;
			} else {
				int insertIx = -(ix + 1);

				// 기존에 존재하는 범위면 Pass
				if (isIncluded(insertIx, newInterval)) return;
				
				if (insertIx == 0) {
					// #0. 초기
					if (intervals.size() == 0) {
						intervals.add(newInterval);
						return ;
					}
					
					// #1.맨 처음
					Interval next = intervals.get(insertIx);
					if (newInterval.end - next.start == -1) {
						next.start = newInterval.end;
					} else {
						intervals.add(0, newInterval);
					}
				} else if (insertIx == intervals.size()) {
					// #2. 마지막
					Interval prev = intervals.get(insertIx-1);
					if (prev.end - newInterval.start == -1) {
						prev.end = newInterval.start;
					} else {
						intervals.add(newInterval);
					}
				} else {
					// #3. 중간
					Interval prev = intervals.get(insertIx - 1);
					Interval next = intervals.get(insertIx);
					
					// ##1 양쪽을 다 붙는 경우
					// ##2 앞에만 붙는경우
					// ##3 뒤에만 붙는경우
					// ##4 다 붙지 못하는 경우
					boolean isPossPrevConnect = prev.end - newInterval.start == -1;
					boolean isPossNextConnect = newInterval.end - next.start == -1;
					if (isPossPrevConnect && isPossNextConnect) {
						Interval nnewInterval = new Interval(prev.start, next.end);
						intervals.remove(insertIx - 1);
						intervals.remove(insertIx - 1);
						intervals.add(insertIx - 1, nnewInterval);
					} else if (isPossPrevConnect) {
						intervals.get(insertIx - 1).end = newInterval.start;
					} else if (isPossNextConnect) {
						intervals.get(insertIx).start = newInterval.end;
					} else {
						intervals.add(insertIx, newInterval);
					}
				}
			}
		}

		private boolean isIncluded(int insertIx, Interval newInterval) {
			int nn = intervals.size();
			if (0 <= insertIx && insertIx < nn) {
				if (intervals.get(insertIx) != null) {
					Interval next = intervals.get(insertIx);
					if (next.start <= newInterval.start && newInterval.end <= next.end) {
						return true;
					}
				} else if (intervals.get(insertIx-1) != null) {
					Interval prev = intervals.get(insertIx);
					if (prev.start <= newInterval.start && newInterval.end <= prev.end) {
						return true;
					}
				}
			}
			return false;
		}

		public List<Interval> getIntervals() {
			return intervals;
		}
	}

	public class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}

		@Override
		public String toString() {
			return "Interval [start=" + start + ", end=" + end + "]";
		}

	}
}
