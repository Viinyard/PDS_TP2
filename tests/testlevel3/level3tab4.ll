; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)
declare i32 @scanf(i8* noalias nocapture, ...)

; Actual code begins

@.str5 = private unnamed_addr constant [3 x i8]c"%d\00", align 1
@.str1 = private unnamed_addr constant [19 x i8]c"Tableau de taille \00", align 1
@.str2 = private unnamed_addr constant [5 x i8]c" = [\00", align 1
@.str6 = private unnamed_addr constant [7 x i8]c"%s%d%s\00", align 1
@.str3 = private unnamed_addr constant [2 x i8]c",\00", align 1
@.str7 = private unnamed_addr constant [3 x i8]c"%s\00", align 1
@.str8 = private unnamed_addr constant [3 x i8]c"%d\00", align 1
@.str4 = private unnamed_addr constant [3 x i8]c"]\0A\00", align 1
@.str9 = private unnamed_addr constant [3 x i8]c"%s\00", align 1

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
	%6 = getelementptr inbounds [3 x i8], [3 x i8]* @.str5, i32 0, i32 0
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
	%13 = getelementptr inbounds [8 x i32], [8 x i32]* %1, i32 0, i32 0
	call void @printtab(i32 8, i32* %13)
	ret void 
}

define void @printtab(i32, i32*) {
entry:
	%2 = alloca i32
	%3 = alloca i32*
	store i32 %0, i32* %2
	store i32* %1, i32** %3
	%4 = alloca i32
	%5 = getelementptr inbounds [19 x i8], [19 x i8]* @.str1, i32 0, i32 0
	%6 = load i32, i32* %2
	%7 = getelementptr inbounds [5 x i8], [5 x i8]* @.str2, i32 0, i32 0
	%8 = getelementptr inbounds [7 x i8], [7 x i8]* @.str6, i32 0, i32 0
	%9 = call i32 (i8*, ...) @printf(i8* %8, i8* %5, i32 %6, i8* %7)
	store i32 0, i32* %4
	br label %entry4
entry4:
	%10 = load i32, i32* %2
	%11 = load i32, i32* %4
	%12 = sub i32 %10, %11
	%13 = icmp ne i32 %12, 0
	br i1 %13, label %do5, label %done6
do5:
	%14 = load i32, i32* %4
	%15 = icmp ne i32 %14, 0
	br i1 %15, label %then7, label %fi8
then7:
	%16 = getelementptr inbounds [2 x i8], [2 x i8]* @.str3, i32 0, i32 0
	%17 = getelementptr inbounds [3 x i8], [3 x i8]* @.str7, i32 0, i32 0
	%18 = call i32 (i8*, ...) @printf(i8* %17, i8* %16)
	br label %fi8
fi8:
	%19 = load i32, i32* %4
	%20 = load i32*, i32** %3
	%21 = getelementptr inbounds i32, i32* %20, i32 %19
	%22 = load i32, i32* %21
	%23 = getelementptr inbounds [3 x i8], [3 x i8]* @.str8, i32 0, i32 0
	%24 = call i32 (i8*, ...) @printf(i8* %23, i32 %22)
	%25 = load i32, i32* %4
	%26 = add i32 %25, 1
	store i32 %26, i32* %4
	br label %entry4
done6:
	%27 = getelementptr inbounds [3 x i8], [3 x i8]* @.str4, i32 0, i32 0
	%28 = getelementptr inbounds [3 x i8], [3 x i8]* @.str9, i32 0, i32 0
	%29 = call i32 (i8*, ...) @printf(i8* %28, i8* %27)
	ret void 
}


