; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)
declare i32 @scanf(i8* noalias nocapture, ...)

; Actual code begins

@.str1 = private unnamed_addr constant [3 x i8]c"%d\00", align 1
@.str2 = private unnamed_addr constant [3 x i8]c"t[\00", align 1
@.str3 = private unnamed_addr constant [5 x i8]c"] = \00", align 1
@.str4 = private unnamed_addr constant [2 x i8]c"\0A\00", align 1
@.str5 = private unnamed_addr constant [11 x i8]c"%s%d%s%d%s\00", align 1

define void @main() {
; <label>:0
	%1 = alloca i32
	%2 = alloca [8 x i32]
	%3 = alloca i32
	store i32 0, i32* %1
	br label %4
; <label>:4
	%5 = load i32, i32* %1
	%6 = sub i32 8, %5
	%7 = icmp ne i32 %6, 0
	br i1 %7, label %8, label %16
; <label>:8
	%9 = getelementptr inbounds [3 x i8], [3 x i8]* @.str1, i32 0, i32 0
	%10 = call i32 (i8*, ...) @scanf(i8* %9, i32* %3)
	%11 = load i32, i32* %3
	%12 = load i32, i32* %1
	%13 = getelementptr inbounds [8 x i32], [8 x i32]* %2, i32 0, i32 %12
	store i32 %11, i32* %13
	%14 = load i32, i32* %1
	%15 = add i32 %14, 1
	store i32 %15, i32* %1
	br label %4
; <label>:16
	store i32 0, i32* %1
	br label %17
; <label>:17
	%18 = load i32, i32* %1
	%19 = sub i32 8, %18
	%20 = icmp ne i32 %19, 0
	br i1 %20, label %21, label %33
; <label>:21
	%22 = getelementptr inbounds [3 x i8], [3 x i8]* @.str2, i32 0, i32 0
	%23 = load i32, i32* %1
	%24 = getelementptr inbounds [5 x i8], [5 x i8]* @.str3, i32 0, i32 0
	%25 = load i32, i32* %1
	%26 = getelementptr inbounds [8 x i32], [8 x i32]* %2, i32 0, i32 %25
	%27 = load i32, i32* %26
	%28 = getelementptr inbounds [2 x i8], [2 x i8]* @.str4, i32 0, i32 0
	%29 = getelementptr inbounds [11 x i8], [11 x i8]* @.str5, i32 0, i32 0
	%30 = call i32 (i8*, ...) @printf(i8* %29, i8* %22, i32 %23, i8* %24, i32 %27, i8* %28)
	%31 = load i32, i32* %1
	%32 = add i32 %31, 1
	store i32 %32, i32* %1
	br label %17
; <label>:33
	ret void 
}


