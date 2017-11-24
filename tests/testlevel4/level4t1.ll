; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)
declare i32 @scanf(i8* noalias nocapture, ...)

; Actual code begins

@.str1 = private unnamed_addr constant [11 x i8]c"Et voila: \00", align 1
@.str2 = private unnamed_addr constant [11 x i8]c"%s%d%d%d%d\00", align 1

define void @main() {
entry:
	%0 = alloca i32
	%1 = alloca i32
	%2 = alloca i32
	%3 = alloca i32
	store i32 0, i32* %0
	store i32 0, i32* %1
	store i32 0, i32* %2
	store i32 0, i32* %3
	%4 = alloca i32
	%5 = alloca i32
	%6 = alloca i32
	store i32 1, i32* %3
	%7 = alloca i32
	%8 = alloca i32
	store i32 2, i32* %6
	%9 = alloca i32
	store i32 3, i32* %8
	%10 = getelementptr inbounds [11 x i8], [11 x i8]* @.str1, i32 0, i32 0
	%11 = load i32, i32* %0
	%12 = load i32, i32* %1
	%13 = load i32, i32* %2
	%14 = load i32, i32* %3
	%15 = getelementptr inbounds [11 x i8], [11 x i8]* @.str2, i32 0, i32 0
	%16 = call i32 (i8*, ...) @printf(i8* %15, i8* %10, i32 %11, i32 %12, i32 %13, i32 %14)
	ret void 
}


