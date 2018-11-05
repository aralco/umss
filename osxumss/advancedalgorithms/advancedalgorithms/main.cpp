//
//  main.cpp
//  advancedalgorithms
//
//  Created by Ariel Alcocer on 10/22/18.
//  Copyright © 2018 Ariel Alcocer. All rights reserved.
//

//#include <iostream>
//
//int main(int argc, const char * argv[]) {
//    // insert code here...
//    std::cout << "Hello, World!\n";
//    return 0;
//}
#include <stdio.h>

int main() {
    int route, r = 0;
    int stop, x;
    scanf("%d", &route);
    for(int r=1;r<=route;r++)   {
        scanf("%d", &stop);
        int tmp = 1, start = 0xffff, end, sum = 0, result = 0;
        for (int i = 2; i <= stop; i++) {
            scanf("%d", &x);
            sum += x;
            if (sum < 0) sum = 0, tmp = i;
            if (sum >= result) {
                if (sum > result || (sum == result && (i - tmp > end - start))) {
                    start = tmp;
                    end = i;
                }
                result = sum;
            }
        }
        if (result > 0)
            printf("The nicest part of route %d is between stops %d and %d\n", r, start, end);
        else
            printf("Route %d has no nice parts\n", r);
    }
    return 0;
}
