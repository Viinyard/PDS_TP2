; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)
declare i32 @scanf(i8* noalias nocapture, ...)

; Actual code begins

@.str4 = private unnamed_addr constant [3 x i8]c"%d\00", align 1
@.str1 = private unnamed_addr constant [3 x i8]c"t[\00", align 1
@.str2 = private unnamed_addr constant [5 x i8]c"] = \00", align 1
@.str3 = private unnamed_addr constant [2 x i8]c"\0A\00", align 1
@.str5 = private unnamed_addr constant [11 x i8]c"%s%d%s%d%s\00", align 1

define void @main() {
entry:
	%0 = alloca i32
	%1 = alloca [8 x i32]
	%2 = alloca i32
	store i32 0, i32* %0
	br label %entry1
entry1:
	%3 = load i32, i32* %0
	%4 = sub i32 8, %3
	%5 = icmp ne i32 %4, 0
	br i1 %5, label %do2, label %done3
do2:
	%6 = getelementptr inbounds [3 x i8], [3 x i8]* @.str4, i32 0, i32 0
	%7 = call i32 (i8*, ...) @scanf(i8* %6, i32* %2)
	%8 = load i32, i32* %0
	%9 = getelementptr inbounds [8 x i32], [8 x i32]* %1, i32 0, i32 %8
	%10 = load i32, i32* %2
	store i32 %10, i32* %9
	%11 = load i32, i32* %0
	%12 = add i32 %11, 1
	store i32 %12, i32* %0
	br label %entry1
done3:
	store i32 0, i32* %0
	br label %entry4
entry4:
	%13 = load i32, i32* %0
	%14 = sub i32 8, %13
	%15 = icmp ne i32 %14, 0
	br i1 %15, label %do5, label %done6
do5:
	%16 = getelementptr inbounds [3 x i8], [3 x i8]* @.str1, i32 0, i32 0
	%17 = load i32, i32* %0
	%18 = getelementptr inbounds [5 x i8], [5 x i8]* @.str2, i32 0, i32 0
	%19 = load i32, i32* %0
	%20 = getelementptr inbounds [8 x i32], [8 x i32]* %1, i32 0, i32 %19
	%21 = load i32, i32* %20
	%22 = getelementptr inbounds [2 x i8], [2 x i8]* @.str3, i32 0, i32 0
	%23 = getelementptr inbounds [11 x i8], [11 x i8]* @.str5, i32 0, i32 0
	%24 = call i32 (i8*, ...) @printf(i8* %23, i8* %16, i32 %17, i8* %18, i32 %21, i8* %22)
	%25 = load i32, i32* %0
	%26 = add i32 %25, 1
	store i32 %26, i32* %0
	br label %entry4
done6:
	ret void 
}


