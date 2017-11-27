; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)
declare i32 @scanf(i8* noalias nocapture, ...)

; Actual code begins

@.str1 = private unnamed_addr constant [7 x i8]c"%d%d%d\00", align 1
@.str2 = private unnamed_addr constant [8 x i8]c"t[0] = \00", align 1
@.str3 = private unnamed_addr constant [9 x i8]c"\0At[1] = \00", align 1
@.str4 = private unnamed_addr constant [9 x i8]c"\0At[2] = \00", align 1
@.str5 = private unnamed_addr constant [13 x i8]c"%s%d%s%d%s%d\00", align 1

define void @main() {
; <label>:0
	%1 = alloca i32
	%2 = alloca i32
	%3 = alloca i32
	%4 = alloca [3 x i32]
	%5 = getelementptr inbounds [7 x i8], [7 x i8]* @.str1, i32 0, i32 0
	%6 = call i32 (i8*, ...) @scanf(i8* %5, i32* %1, i32* %2, i32* %3)
	%7 = load i32, i32* %1
	%8 = getelementptr inbounds [3 x i32], [3 x i32]* %4, i32 0, i32 0
	store i32 %7, i32* %8
	%9 = load i32, i32* %2
	%10 = getelementptr inbounds [3 x i32], [3 x i32]* %4, i32 0, i32 1
	store i32 %9, i32* %10
	%11 = load i32, i32* %3
	%12 = getelementptr inbounds [3 x i32], [3 x i32]* %4, i32 0, i32 2
	store i32 %11, i32* %12
	%13 = getelementptr inbounds [8 x i8], [8 x i8]* @.str2, i32 0, i32 0
	%14 = getelementptr inbounds [3 x i32], [3 x i32]* %4, i32 0, i32 0
	%15 = load i32, i32* %14
	%16 = getelementptr inbounds [9 x i8], [9 x i8]* @.str3, i32 0, i32 0
	%17 = getelementptr inbounds [3 x i32], [3 x i32]* %4, i32 0, i32 1
	%18 = load i32, i32* %17
	%19 = getelementptr inbounds [9 x i8], [9 x i8]* @.str4, i32 0, i32 0
	%20 = getelementptr inbounds [3 x i32], [3 x i32]* %4, i32 0, i32 2
	%21 = load i32, i32* %20
	%22 = getelementptr inbounds [13 x i8], [13 x i8]* @.str5, i32 0, i32 0
	%23 = call i32 (i8*, ...) @printf(i8* %22, i8* %13, i32 %15, i8* %16, i32 %18, i8* %19, i32 %21)
	ret void 
}


