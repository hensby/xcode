import java.util.*;

public class PrisonAfterNDays {

    public int[] prisonAfterNDays(int[] cells, int N) {
        N = N % 14;
        if (N == 0) return cells;
        for (int i = 0; i < N; i++) {
            int[] k=new int[8];
            k[0] = 0;
            k[7] = 0;
            for (int j = 1; j < 7; j++) {
                if ((cells[j-1] == 0 && cells[j+1] == 0) || (cells[j-1] ==1 && cells[j+1] == 1)) k[j] = 1;
                else k[j] = 0;
            }
            cells = k;
        }
        return cells;
    }

    public int[] prisonAfterNDays1(int[] cells, int N) {
        Map<Integer, Integer> seen = new HashMap();

        // state  = integer representing state of prison
        int state = 0;
        for (int i = 0; i < 8; ++i) {
            if (cells[i] > 0)
                state ^= 1 << i;
        }

        // While days remaining, simulate a day
        while (N > 0) {
            // If this is a cycle, fast forward by
            // seen.get(state) - N, the period of the cycle.
            if (seen.containsKey(state)) {
                N %= seen.get(state) - N;
            }
            seen.put(state, N);

            if (N >= 1) {
                N--;
                state = nextDay(state);
            }
        }

        // Convert the state back to the required answer.
        int[] ans = new int[8];
        for (int i = 0; i < 8; ++i) {
            if (((state >> i) & 1) > 0) {
                ans[i] = 1;
            }
        }

        return ans;
    }

    public int nextDay(int state) {
        int ans = 0;

        // We only loop from 1 to 6 because 0 and 7 are impossible,
        // as those cells only have one neighbor.
        for (int i = 1; i <= 6; ++i) {
            if (((state >> (i-1)) & 1) == ((state >> (i+1)) & 1)) {
                ans ^= 1 << i;
            }
        }

        return ans;
    }

    int len;
    public int[] prisonAfterNDays3(int[] cells, int N) {
        List<int[]> cycleCells = new ArrayList<int[]>();
        int cycle = 0;
        this.len = cells.length;
        int[] firstCells = new int[len];
        for(int i = 0; i < N; i++) {
            int[] cur = processArray(cells);
            if(i == 0) {
                firstCells = cur;
                cycleCells.add(cur);
                continue;
            }
            if(!Arrays.equals(cur, firstCells)) {
                cycleCells.add(cur);
            } else {
                cycle = i;
                int index = N % cycle == 0? cycle: N % cycle;
                int[] res = cycleCells.get(index - 1);
                return res;
            }
        }
        return cells;
    }

    public int[] processArray(int[] cur) {
        int[] res = new int[len];
        for(int i = 0; i < len; i++) {
            if(i == 0 || i == len - 1) res[i] = 0;
            else {
                if(cur[i - 1] == cur[i + 1]) res[i] = 1;
                else res[i] = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] s = new int[] {0,1,0,1,1,0,0,1};
        PrisonAfterNDays prisonAfterNDays = new PrisonAfterNDays();
        System.out.println(Arrays.toString(prisonAfterNDays.prisonAfterNDays3(s, 7)));
    }
}

