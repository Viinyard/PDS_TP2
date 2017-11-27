; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)
declare i32 @scanf(i8* noalias nocapture, ...)

; Actual code begins

@.str1 = private unnamed_addr constant [19 x i8]c" est different de \00", align 1
@.str2 = private unnamed_addr constant [2 x i8]c"\0A\00", align 1
@.str3 = private unnamed_addr constant [9 x i8]c"%d%s%d%s\00", align 1
@.str4 = private unnamed_addr constant [13 x i8]c" est egal a \00", align 1
@.str5 = private unnamed_addr constant [2 x i8]c"\0A\00", align 1
@.str6 = private unnamed_addr constant [9 x i8]c"%d%s%d%s\00", align 1

define void @main() {
; <label>:0
	call void @compare(i32 2, i32 1)
	call void @compare(i32 1, i32 2)
	call void @compare(i32 1, i32 1)
	ret void 
}

define void @compare(i32, i32) {
; <label>:2
	%3 = alloca i32
	%4 = alloca i32
	store i32 %0, i32* %3
	store i32 %1, i32* %4
	%5 = load i32, i32* %3
	%6 = load i32, i32* %4
	%7 = sub i32 %5, %6
	%8 = icmp ne i32 %7, 0
	br i1 %8, label %9, label %16
; <label>:9
	%10 = load i32, i32* %3
	%11 = getelementptr inbounds [19 x i8], [19 x i8]* @.str1, i32 0, i32 0
	%12 = load i32, i32* %4
	%13 = getelementptr inbounds [2 x i8], [2 x i8]* @.str2, i32 0, i32 0
	%14 = getelementptr inbounds [9 x i8], [9 x i8]* @.str3, i32 0, i32 0
	%15 = call i32 (i8*, ...) @printf(i8* %14, i32 %10, i8* %11, i32 %12, i8* %13)
	br label %23
; <label>:16
	%17 = load i32, i32* %3
	%18 = getelementptr inbounds [13 x i8], [13 x i8]* @.str4, i32 0, i32 0
	%19 = load i32, i32* %4
	%20 = getelementptr inbounds [2 x i8], [2 x i8]* @.str5, i32 0, i32 0
	%21 = getelementptr inbounds [9 x i8], [9 x i8]* @.str6, i32 0, i32 0
	%22 = call i32 (i8*, ...) @printf(i8* %21, i32 %17, i8* %18, i32 %19, i8* %20)
	br label %23
; <label>:23
	ret void 
}


