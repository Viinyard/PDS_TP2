; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)
declare i32 @scanf(i8* noalias nocapture, ...)

; Actual code begins

@.str4 = private unnamed_addr constant [7 x i8]c"%d%d%d\00", align 1
@.str1 = private unnamed_addr constant [8 x i8]c"t[0] = \00", align 1
@.str2 = private unnamed_addr constant [9 x i8]c"\0At[1] = \00", align 1
@.str3 = private unnamed_addr constant [9 x i8]c"\0At[2] = \00", align 1
@.str5 = private unnamed_addr constant [13 x i8]c"%s%d%s%d%s%d\00", align 1

define void @main() {
entry:
	%0 = alloca i32
	%1 = alloca i32
	%2 = alloca i32
	%3 = alloca [3 x i32]
	%4 = getelementptr inbounds [7 x i8], [7 x i8]* @.str4, i32 0, i32 0
	%5 = call i32 (i8*, ...) @scanf(i8* %4, i32* %0, i32* %1, i32* %2)
	%6 = getelementptr inbounds [3 x i32], [3 x i32]* %3, i32 0, i32 0
	%7 = load i32, i32* %0
	store i32 %7, i32* %6
	%8 = getelementptr inbounds [3 x i32], [3 x i32]* %3, i32 0, i32 1
	%9 = load i32, i32* %1
	store i32 %9, i32* %8
	%10 = getelementptr inbounds [3 x i32], [3 x i32]* %3, i32 0, i32 2
	%11 = load i32, i32* %2
	store i32 %11, i32* %10
	%12 = getelementptr inbounds [8 x i8], [8 x i8]* @.str1, i32 0, i32 0
	%13 = getelementptr inbounds [3 x i32], [3 x i32]* %3, i32 0, i32 0
	%14 = load i32, i32* %13
	%15 = getelementptr inbounds [9 x i8], [9 x i8]* @.str2, i32 0, i32 0
	%16 = getelementptr inbounds [3 x i32], [3 x i32]* %3, i32 0, i32 1
	%17 = load i32, i32* %16
	%18 = getelementptr inbounds [9 x i8], [9 x i8]* @.str3, i32 0, i32 0
	%19 = getelementptr inbounds [3 x i32], [3 x i32]* %3, i32 0, i32 2
	%20 = load i32, i32* %19
	%21 = getelementptr inbounds [13 x i8], [13 x i8]* @.str5, i32 0, i32 0
	%22 = call i32 (i8*, ...) @printf(i8* %21, i8* %12, i32 %14, i8* %15, i32 %17, i8* %18, i32 %20)
	ret void 
}


