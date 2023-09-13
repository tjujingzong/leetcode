#include <bits/stdc++.h>
using namespace std;

int main() {
  string s;
  unordered_set<string> st;
  while (cin >> s) {
    st.insert(s);
  }
  int n = st.size();
  for (int i = 0; i < (1 << n); i++) {
    string s = "";
    for (int j = 0; j < n; j++) {
      s += (i >> j & 1) ? '1' : '0';
    }
    if (st.count(s) == 0) {
      cout << s << endl;
      return 0;
    }
  }
}