// 미완성

package dp0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class RGBDistance {
	static int[][] arr;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1][3];
		StringTokenizer st;
		for(int i=1;i<n+1;i++) {
			st = new StringTokenizer(br.readLine()," ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}
		br.close();
		int R = getSum(1);
		int G = getSum(2);
		int B = getSum(3);
		bw.write(R+"\n");
		bw.write(G+"\n");
		bw.write(B+"\n");
		bw.flush();
		bw.close();
	}
	public static int getSum(int c) {
		int[] color = new int[n+1];
		// red : 1, green : 2, blue : 3
		color[1]=c;
		int[] sum = new int[n+1];
		sum[1]=arr[1][0];
		for(int i=2;i<n+1;i++) {
			if(color[i-1]==1) {
				if(arr[i][1]+sum[i-1]>arr[i][2]+sum[i-1]) {
					sum[i]=arr[i][2]+sum[i-1];
					color[i] = 3;
				} else if(arr[i][1]+sum[i-1]<arr[i][2]+sum[i-1]) {
					sum[i]=arr[i][1]+sum[i-1];
					color[i]= 2;
				} else if(i<n) {
					int t=i+1;
					boolean flag = true;
					while(flag) {
						if(arr[t][1]>arr[t][2]) {
							sum[i]=arr[i][1]+sum[i-1];
							color[i]= 2;
							flag=false;
							break;
						} else if(arr[t][1]<arr[t][2]) {
							sum[i]=arr[i][2]+sum[i-1];
							color[i] = 3;
							flag = false;
							break;
						} else {
							t++;
							if(t>n) {
								sum[i]=arr[i][2]+sum[i-1];
								color[i] = 3;
								flag = false;
								break;
							}
						}
					}
				}
			} else if(color[i-1]==2) {
				if(arr[i][0]+sum[i-1]>arr[i][2]+sum[i-1]) {
					sum[i]=arr[i][2]+sum[i-1];
					color[i] = 3;
				} else if(arr[i][0]+sum[i-1]<arr[i][2]+sum[i-1]) {
					sum[i]=arr[i][0]+sum[i-1];
					color[i]= 1;
				} else if(i<n) {
					int t=i+1;
					boolean flag = true;
					while(flag) {
						if(arr[t][0]>arr[t][2]) {
							sum[i]=arr[i][0]+sum[i-1];
							color[i]= 1;
							flag=false;
							break;
						} else if(arr[t][0]<arr[t][2]) {
							sum[i]=arr[i][2]+sum[i-1];
							color[i] = 3;
							flag = false;
							break;
						} else {
							t++;
							if(t>n) {
								sum[i]=arr[i][2]+sum[i-1];
								color[i] = 3;
								flag = false;
								break;
							}
						}
					}
				}
			} else if(color[i-1]==3) {
				if(arr[i][1]+sum[i-1]>arr[i][0]+sum[i-1]) {
					sum[i]=arr[i][0]+sum[i-1];
					color[i] = 1;
				} else if(arr[i][1]+sum[i-1]<arr[i][0]+sum[i-1]) {
					sum[i]=arr[i][1]+sum[i-1];
					color[i]= 2;
				} else if(i<n) {
					int t=i+1;
					boolean flag = true;
					while(flag) {
						if(arr[t][1]>arr[t][0]) {
							sum[i]=arr[i][0]+sum[i-1];
							color[i]= 1;
							flag=false;
							break;
						} else if(arr[t][1]<arr[t][0]) {
							sum[i]=arr[i][0]+sum[i-1];
							color[i] = 2;
							flag = false;
							break;
						} else {
							t++;
							if(t>n) {
								sum[i]=arr[i][2]+sum[i-1];
								color[i] = 3;
								flag = false;
								break;
							}
						}
					}
				}
			}
		}
		return sum[n];
	}
}
