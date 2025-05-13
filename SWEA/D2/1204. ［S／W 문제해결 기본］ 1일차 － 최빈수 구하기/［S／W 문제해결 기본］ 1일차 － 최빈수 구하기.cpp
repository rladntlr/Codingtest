#include <bits/stdc++.h>

using namespace std;

int main(int argc, char** argv)
{
	int t;
    cin >> t;
    
    for(int i=1; i<=t; i++){
        vector<int> v(101);
        int tc;
        cin >> tc;
        
        for(int j=0; j<1000; j++){
            int n;
            cin >> n;
            
            v[n]++;
        }
        
        int m=*max_element(v.begin(), v.end());
        for(int j=100; j>=0; j--){
            if(v[j]==m){
                cout << "#" << i << " " << j << "\n";
                break;
            }
        }
    }
    
	return 0;
}