; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)
declare i32 @scanf(i8* noalias nocapture, ...)

; Actual code begins

@.str1 = private unnamed_addr constant [3 x i8]c"%d\00", align 1
@.str2 = private unnamed_addr constant [3 x i8]c"%d\00", align 1
@.str3 = private unnamed_addr constant [22 x i8]c"y a l'interieur vaut \00", align 1
@.str4 = private unnamed_addr constant [5 x i8]c"%s%d\00", align 1
@.str5 = private unnamed_addr constant [38 x i8]c", mais a l'exterieur du bloc il vaut \00", align 1
@.str6 = private unnamed_addr constant [5 x i8]c"%s%d\00", align 1

define void @main() {
; <label>:0
	%1 = alloca i32
	%2 = alloca i32
	%3 = getelementptr inbounds [3 x i8], [3 x i8]* @.str1, i32 0, i32 0
	%4 = call i32 (i8*, ...) @scanf(i8* %3, i32* %1)
	%5 = getelementptr inbounds [3 x i8], [3 x i8]* @.str2, i32 0, i32 0
	%6 = call i32 (i8*, ...) @scanf(i8* %5, i32* %2)
	%7 = getelementptr inbounds [22 x i8], [22 x i8]* @.str3, i32 0, i32 0
	%8 = load i32, i32* %2
	%9 = getelementptr inbounds [5 x i8], [5 x i8]* @.str4, i32 0, i32 0
	%10 = call i32 (i8*, ...) @printf(i8* %9, i8* %7, i32 %8)
	%11 = getelementptr inbounds [38 x i8], [38 x i8]* @.str5, i32 0, i32 0
	%12 = load i32, i32* %1
	%13 = getelementptr inbounds [5 x i8], [5 x i8]* @.str6, i32 0, i32 0
	%14 = call i32 (i8*, ...) @printf(i8* %13, i8* %11, i32 %12)
	ret void 
}


