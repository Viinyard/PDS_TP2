; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)
declare i32 @scanf(i8* noalias nocapture, ...)

; Actual code begins

@.str1 = private unnamed_addr constant [7 x i8]c"%d%d%d\00", align 1
@.str2 = private unnamed_addr constant [7 x i8]c"%d%d%d\00", align 1

define void @main() {
; <label>:0
	%1 = alloca i32
	%2 = alloca [3 x i32]
	%3 = getelementptr inbounds [3 x i32], [3 x i32]* %2, i32 0, i32 0
	%4 = getelementptr inbounds [3 x i32], [3 x i32]* %2, i32 0, i32 1
	%5 = getelementptr inbounds [3 x i32], [3 x i32]* %2, i32 0, i32 2
	%6 = getelementptr inbounds [7 x i8], [7 x i8]* @.str1, i32 0, i32 0
	%7 = call i32 (i8*, ...) @scanf(i8* %6, i32* %3, i32* %4, i32* %5)
	%8 = getelementptr inbounds [3 x i32], [3 x i32]* %2, i32 0, i32 0
	%9 = load i32, i32* %8
	%10 = getelementptr inbounds [3 x i32], [3 x i32]* %2, i32 0, i32 1
	%11 = load i32, i32* %10
	%12 = getelementptr inbounds [3 x i32], [3 x i32]* %2, i32 0, i32 2
	%13 = load i32, i32* %12
	%14 = getelementptr inbounds [7 x i8], [7 x i8]* @.str2, i32 0, i32 0
	%15 = call i32 (i8*, ...) @printf(i8* %14, i32 %9, i32 %11, i32 %13)
	ret void 
}


