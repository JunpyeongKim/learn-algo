/**
 * 1.2 널 문자로 끝나는 문자열을 뒤집는 reverse(char* str) 함수를 C나 C++로 구현하라.
 *
 * (4E)
 * 1.2 Write code to reverse a C-Style String.
 *     (C-String means that “abcd” is represented as five characters, including the null character.)
 */
 #include <stdlib.h>
 #include <stdio.h>

void reverse(char* str) {
    if (str == NULL) {
        printf("[reverse()] str == NULL\n");
        return;
    }

    // length
    int i, length;
    for (i = 0; ; i++) {
        if (str[i] == '\0') {
            break;
        }
    }

    length = i;

    // reverse
    if (length > 0) {
        char* rev = malloc(length * sizeof(char));

        for (i = 0; i < length; i++) {
            rev[length-1-i] = str[i];
        }

        for (i = 0; i < length; i++) {
            str[i] = rev[i];
        }

        free(rev);
    }
}

int is_reverse(char* str, char* rev) {
    // NULL
    if (str == NULL || rev == NULL) {
        printf("[reverse()] str == NULL || rev == NULL\n");
        return 0;
    }

    // length
    int i, length;
    for (i = 0; ; i++) {
        if (str[i] == '\0') {
            break;
        }
    }

    length = i;

    for (i = 0; ; i++) {
        if (rev[i] == '\0') {
            if (i != length) {
                printf("[is_reverse()] i != length : %d, %d\n", i, length);
                return 0;
            }
            break;
        }
    }

    for (i = 0; i < length; i++) {
        if (str[i] != rev[length-1-i]) {
            printf("[is_reverse()] str[i] != rev[length-1-i]: %c, %c", str[i], rev[length-1-i]);
            return 0;
        }
    }

    return 1;
}

int main() {
    char str[20] = "abcdefg";
    char str_backup[20] = "abcdefg";
    char* null = NULL;

    reverse(str);
    if (is_reverse(str, str_backup)) {
        printf("passed: %s\n", str);
    } else {
        printf("failed: %s\n", str);
    }

    reverse(null);
    if (null == NULL) {
        printf("passed: NULL\n");
    } else {
        printf("failed: NULL\n");
    }
    return 0;
}