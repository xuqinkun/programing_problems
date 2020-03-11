#include <iostream>
#include<cstdlib>
#include<vector>
#define N 54

using namespace std;

void xipai(vector<int> &data) {
	int cnt;
	for(int i=0;i<N;++i) {
		cnt = rand() % (N-i);
		swap(data[cnt], data[N-i-1]);
	}
	return;
}

int main()
{
	vector<int> data(N);
	for(int i=0;i<N;++i)
		data[i]=i+1;
	xipai(data);
	for(int i=0;i<N;++i)
		cout<<data[i]<<" ";
	return 0;
}
