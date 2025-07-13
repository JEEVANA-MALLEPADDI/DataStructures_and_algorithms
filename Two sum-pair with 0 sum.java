// Two sum -Pairs with 0 Sum

//link[https://www.geeksforgeeks.org/problems/count-pairs-with-given-sum5022/1]


// Difficulty: EasyAccuracy: 31.49%Submissions: 492K+Points: 2Average Time: 20m
// Given an integer array arr, return all the unique pairs [arr[i], arr[j]] such that i != j and arr[i] + arr[j] == 0.

// Note: The pairs must be returned in sorted order, the solution array should also be sorted, and the answer must not contain any duplicate pairs.

// Examples:

// Input: arr = [-1, 0, 1, 2, -1, -4]
// Output: [[-1, 1]]
// Explanation: arr[0] + arr[2] = (-1)+ 1 = 0.
// arr[2] + arr[4] = 1 + (-1) = 0.
// The distinct pair are [-1,1].
// Input: arr = [6, 1, 8, 0, 4, -9, -1, -10, -6, -5]
// Output: [[-6, 6],[-1, 1]]
// Explanation: The distinct pairs are [-1, 1] and [-6, 6].
// Expected Time Complexity: O(n log n)
// Expected Auxiliary Space: O(n).

// Constraints:
// 3 <= arr.size <= 105
// -105 <= arr[i] <= 105



class Solution {
    public static ArrayList<ArrayList<Integer>> getPairs(int[] arr) {
        // code here
        // ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        // boolean[] visited=new boolean[n];
        // int n=arr.length;
        // for(int i=0;i<n;i++){
        //     if(visited[i])continue;
        //     for(int j=i+1;j<n;j++){
        //         if(arr[i]+arr[j]==0 && !visited[j]){
        //             Arraylist<Integer> a=new ArrayList<>;
        //             visited[i]=true;
        //             visited[j]=true;
        //             a.add(arr[i]);
        //             a.add(arr[j]);
                   
        //             res.add(a);
        //         }
        //     }
        // }
        // return res;
        
        //the above is brute forse sollution and 
        //time complexity is O(n^2)
        
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        HashSet<String>used=new HashSet<>();
        for(int item: arr){
            map.put(item,map.getOrDefault(item,0)+1);
        }
        for(int item:arr){
            if(item!=0 && map.containsKey(-item) && map.get(item)>0 && map.get(-item)>0){
                int a=Math.min(item,-item);
                int b=Math.max(item,-item);
                String key=a+","+b;
                if(!used.contains(key)){
                     ArrayList<Integer> pair=new ArrayList<>();
                    pair.add(a);
                    pair.add(b);
                    res.add(pair);
                    used.add(key);
                }
               
                map.put(item,map.get(item)-1);
                map.put(-item,map.get(-item)-1);
            }
            if(item==0 && map.get(0)>1 && !used.contains("0,0")){
                ArrayList<Integer> pair=new ArrayList<>();
                pair.add(0);
                pair.add(0);
                res.add(pair);
                used.add("0,0");
                map.put(0,0);
            }
        }
        Collections.sort(res, new Comparator<ArrayList<Integer>>() {
    public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
        return Integer.compare(a.get(0), b.get(0)); // sort by first element
    }
});
return res;
        
    }
}
