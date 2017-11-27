; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)
declare i32 @scanf(i8* noalias nocapture, ...)

; Actual code begins

@.str1 = private unnamed_addr constant [3 x i8]c"f(\00", align 1
@.str2 = private unnamed_addr constant [5 x i8]c") = \00", align 1
@.str3 = private unnamed_addr constant [2 x i8]c"\0A\00", align 1
@.str4 = private unnamed_addr constant [11 x i8]c"%s%d%s%d%s\00", align 1

define void @main() {
; <label>:0
	%1 = alloca i32
	%2 = alloca [11 x i32]
	store i32 0, i32* %1
	br label %3
; <label>:3
	%4 = load i32, i32* %1
	%5 = sub i32 11, %4
	%6 = icmp ne i32 %5, 0
	br i1 %6, label %7, label %14
; <label>:7
	%8 = load i32, i32* %1
	%9 = call i32 @fact(i32 %8)
	%10 = load i32, i32* %1
	%11 = getelementptr inbounds [11 x i32], [11 x i32]* %2, i32 0, i32 %10
	store i32 %9, i32* %11
	%12 = load i32, i32* %1
	%13 = add i32 %12, 1
	store i32 %13, i32* %1
	br label %3
; <label>:14
	store i32 0, i32* %1
	br label %15
; <label>:15
	%16 = load i32, i32* %1
	%17 = sub i32 11, %16
	%18 = icmp ne i32 %17, 0
	br i1 %18, label %19, label %31
; <label>:19
	%20 = getelementptr inbounds [3 x i8], [3 x i8]* @.str1, i32 0, i32 0
	%21 = load i32, i32* %1
	%22 = getelementptr inbounds [5 x i8], [5 x i8]* @.str2, i32 0, i32 0
	%23 = load i32, i32* %1
	%24 = getelementptr inbounds [11 x i32], [11 x i32]* %2, i32 0, i32 %23
	%25 = load i32, i32* %24
	%26 = getelementptr inbounds [2 x i8], [2 x i8]* @.str3, i32 0, i32 0
	%27 = getelementptr inbounds [11 x i8], [11 x i8]* @.str4, i32 0, i32 0
	%28 = call i32 (i8*, ...) @printf(i8* %27, i8* %20, i32 %21, i8* %22, i32 %25, i8* %26)
	%29 = load i32, i32* %1
	%30 = add i32 %29, 1
	store i32 %30, i32* %1
	br label %15
; <label>:31
	ret void 
}

define i32 @fact(i32) {
; <label>:1
	%2 = alloca i32
	%3 = alloca i32
	store i32 %0, i32* %2
	%4 = load i32, i32* %2
	%5 = icmp ne i32 %4, 0
	br i1 %5, label %6, label %12
; <label>:6
	%7 = load i32, i32* %2
	%8 = load i32, i32* %2
	%9 = sub i32 %8, 1
	%10 = call i32 @fact(i32 %9)
	%11 = mul i32 %7, %10
	store i32 %11, i32* %3
	br label %13
; <label>:12
	store i32 1, i32* %3
	br label %13
; <label>:13
	%14 = load i32, i32* %3
	ret i32 %14
}


