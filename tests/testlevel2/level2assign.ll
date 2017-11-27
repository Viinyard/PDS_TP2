; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)
declare i32 @scanf(i8* noalias nocapture, ...)

; Actual code begins

@.str1 = private unnamed_addr constant [3 x i8]c"%d\00", align 1
@.str2 = private unnamed_addr constant [8 x i8]c"y vaut \00", align 1
@.str3 = private unnamed_addr constant [5 x i8]c"%s%d\00", align 1

define void @main() {
; <label>:0
	%1 = alloca i32
	%2 = alloca i32
	%3 = getelementptr inbounds [3 x i8], [3 x i8]* @.str1, i32 0, i32 0
	%4 = call i32 (i8*, ...) @scanf(i8* %3, i32* %1)
	%5 = load i32, i32* %1
	store i32 %5, i32* %2
	%6 = getelementptr inbounds [8 x i8], [8 x i8]* @.str2, i32 0, i32 0
	%7 = load i32, i32* %2
	%8 = getelementptr inbounds [5 x i8], [5 x i8]* @.str3, i32 0, i32 0
	%9 = call i32 (i8*, ...) @printf(i8* %8, i8* %6, i32 %7)
	ret void 
}


