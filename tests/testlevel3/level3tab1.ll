; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)
declare i32 @scanf(i8* noalias nocapture, ...)

; Actual code begins

@.str1 = private unnamed_addr constant [7 x i8]c"%d%d%d\00", align 1
@.str2 = private unnamed_addr constant [7 x i8]c"%d%d%d\00", align 1

define void @main() {
entry:
	%0 = alloca i32
	%1 = alloca [3 x i32]
	%2 = getelementptr inbounds [3 x i32], [3 x i32]* %1, i32 0, i32 0
	%3 = getelementptr inbounds [3 x i32], [3 x i32]* %1, i32 0, i32 1
	%4 = getelementptr inbounds [3 x i32], [3 x i32]* %1, i32 0, i32 2
	%5 = getelementptr inbounds [7 x i8], [7 x i8]* @.str1, i32 0, i32 0
	%6 = call i32 (i8*, ...) @scanf(i8* %5, i32* %2, i32* %3, i32* %4)
	%7 = getelementptr inbounds [3 x i32], [3 x i32]* %1, i32 0, i32 0
	%8 = load i32, i32* %7
	%9 = getelementptr inbounds [3 x i32], [3 x i32]* %1, i32 0, i32 1
	%10 = load i32, i32* %9
	%11 = getelementptr inbounds [3 x i32], [3 x i32]* %1, i32 0, i32 2
	%12 = load i32, i32* %11
	%13 = getelementptr inbounds [7 x i8], [7 x i8]* @.str2, i32 0, i32 0
	%14 = call i32 (i8*, ...) @printf(i8* %13, i32 %8, i32 %10, i32 %12)
	ret void 
}


