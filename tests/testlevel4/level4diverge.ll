; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)
declare i32 @scanf(i8* noalias nocapture, ...)

; Actual code begins

@.str1 = private unnamed_addr constant [5 x i8]c"Toto\00", align 1
@.str2 = private unnamed_addr constant [3 x i8]c"%s\00", align 1

define void @main() {
; <label>:0
	%1 = alloca i32
	%2 = alloca i32
	%3 = getelementptr inbounds [5 x i8], [5 x i8]* @.str1, i32 0, i32 0
	%4 = getelementptr inbounds [3 x i8], [3 x i8]* @.str2, i32 0, i32 0
	%5 = call i32 (i8*, ...) @printf(i8* %4, i8* %3)
	store i32 10, i32* %1
	br label %6
; <label>:6
	%7 = load i32, i32* %1
	%8 = sub i32 %7, 1
	%9 = icmp ne i32 %8, 0
	br i1 %9, label %10, label %11
; <label>:10
	store i32 1, i32* %2
	br label %6
; <label>:11
	ret void 
}


