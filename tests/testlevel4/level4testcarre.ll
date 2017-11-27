; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)
declare i32 @scanf(i8* noalias nocapture, ...)

; Actual code begins

@.str1 = private unnamed_addr constant [2 x i8]c"\0A\00", align 1
@.str2 = private unnamed_addr constant [3 x i8]c"%s\00", align 1
@.str3 = private unnamed_addr constant [6 x i8]c"^2 + \00", align 1
@.str4 = private unnamed_addr constant [5 x i8]c"%d%s\00", align 1
@.str5 = private unnamed_addr constant [7 x i8]c"1^2 = \00", align 1
@.str6 = private unnamed_addr constant [2 x i8]c"\0A\00", align 1
@.str7 = private unnamed_addr constant [7 x i8]c"%s%d%s\00", align 1

define void @main() {
; <label>:0
	%1 = alloca i32
	%2 = alloca i32
	%3 = alloca i32
	store i32 5, i32* %1
	store i32 0, i32* %3
	%4 = load i32, i32* %1
	store i32 %4, i32* %2
	br label %5
; <label>:5
	%6 = load i32, i32* %2
	%7 = icmp ne i32 %6, 0
	br i1 %7, label %8, label %16
; <label>:8
	%9 = load i32, i32* %3
	%10 = load i32, i32* %2
	%11 = load i32, i32* %2
	%12 = mul i32 %10, %11
	%13 = add i32 %9, %12
	store i32 %13, i32* %3
	%14 = load i32, i32* %2
	%15 = sub i32 %14, 1
	store i32 %15, i32* %2
	br label %5
; <label>:16
	%17 = getelementptr inbounds [2 x i8], [2 x i8]* @.str1, i32 0, i32 0
	%18 = getelementptr inbounds [3 x i8], [3 x i8]* @.str2, i32 0, i32 0
	%19 = call i32 (i8*, ...) @printf(i8* %18, i8* %17)
	%20 = load i32, i32* %1
	store i32 %20, i32* %2
	br label %21
; <label>:21
	%22 = load i32, i32* %2
	%23 = sub i32 %22, 1
	%24 = icmp ne i32 %23, 0
	br i1 %24, label %25, label %32
; <label>:25
	%26 = load i32, i32* %2
	%27 = getelementptr inbounds [6 x i8], [6 x i8]* @.str3, i32 0, i32 0
	%28 = getelementptr inbounds [5 x i8], [5 x i8]* @.str4, i32 0, i32 0
	%29 = call i32 (i8*, ...) @printf(i8* %28, i32 %26, i8* %27)
	%30 = load i32, i32* %2
	%31 = sub i32 %30, 1
	store i32 %31, i32* %2
	br label %21
; <label>:32
	%33 = getelementptr inbounds [7 x i8], [7 x i8]* @.str5, i32 0, i32 0
	%34 = load i32, i32* %3
	%35 = getelementptr inbounds [2 x i8], [2 x i8]* @.str6, i32 0, i32 0
	%36 = getelementptr inbounds [7 x i8], [7 x i8]* @.str7, i32 0, i32 0
	%37 = call i32 (i8*, ...) @printf(i8* %36, i8* %33, i32 %34, i8* %35)
	ret void 
}


