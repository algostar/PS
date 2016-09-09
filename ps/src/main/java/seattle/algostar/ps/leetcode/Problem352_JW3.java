package seattle.algostar.ps.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Problem352_JW3 {
	public static void main(String[] args) {
		new Problem352_JW3().solve();
	}

	private void solve() {
		SummaryRanges r = new SummaryRanges();
		int[] A = {1, 5, 6, 7, 8, 6, 2};
//		int[] A = {6, 6, 0, 4, 8, 7, 6, 4, 7, 5};
//		int[] A = {0, 1, 2, 3, 4, 5, 4};
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

		int STATUS_PARTED = 0;
		int STATUS_CONNECTABLE = 1;
		int STATUS_INCLUDED = 2;

		public void addNum(int val) {
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
				if (intervals.size() == 0) { intervals.add(newInterval); return ; }
				
				int prevStatus = getPrevStatus(insertIx, newInterval, intervals);
				int nextStatus = getNextStatus(insertIx, newInterval, intervals);
				
				if (prevStatus == STATUS_INCLUDED || nextStatus == STATUS_INCLUDED) return;
				
				if (prevStatus == STATUS_CONNECTABLE && nextStatus == STATUS_CONNECTABLE) {
					Interval prev = intervals.get(insertIx-1);
					Interval next = intervals.get(insertIx);
					prev.end = next.end;
					intervals.remove(insertIx);
				} else if (nextStatus == STATUS_CONNECTABLE) {
					Interval next = intervals.get(insertIx);
					next.start = newInterval.end;
				} else if (prevStatus == STATUS_CONNECTABLE) {
					Interval prev = intervals.get(insertIx-1);
					prev.end = newInterval.end;
				} else {
					intervals.add(insertIx, newInterval);
				}
			}
		}

		private int getNextStatus(int insertIx, Interval newInterval, List<Interval> intervals) {
			int nextIx = insertIx;
			if (nextIx < intervals.size()) {
				Interval next = intervals.get(nextIx);
				if (newInterval.end - next.start == -1) {
					return STATUS_CONNECTABLE;
				} else if (next.start <= newInterval.end) {
					return STATUS_INCLUDED;
				}
			} 
			return STATUS_PARTED;
		}

		private int getPrevStatus(int insertIx, Interval newInterval, List<Interval> intervals) {
			int prevIx = insertIx - 1;
			if (0 <= prevIx) {
				Interval prev = intervals.get(prevIx);
				if (prev.end - newInterval.start == -1) {
					return STATUS_CONNECTABLE;
				} else if (newInterval.start <= prev.end) {
					return STATUS_INCLUDED;
				}
			}
			return STATUS_PARTED;
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
