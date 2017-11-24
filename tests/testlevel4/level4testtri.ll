; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)
declare i32 @scanf(i8* noalias nocapture, ...)

; Actual code begins

@.str1 = private unnamed_addr constant [13 x i8]c"\0A Entrer le \00", align 1
@.str2 = private unnamed_addr constant [7 x i8]c"eme:  \00", align 1
@.str5 = private unnamed_addr constant [7 x i8]c"%s%d%s\00", align 1
@.str6 = private unnamed_addr constant [3 x i8]c"%d\00", align 1
@.str3 = private unnamed_addr constant [5 x i8]c"\0A t[\00", align 1
@.str4 = private unnamed_addr constant [5 x i8]c"] = \00", align 1
@.str7 = private unnamed_addr constant [9 x i8]c"%s%d%s%d\00", align 1

define void @main() {
entry:
	%0 = alloca [10 x i32]
	%1 = alloca i32
	%2 = alloca i32
	store i32 0, i32* %1
	br label %entry1
entry1:
	%3 = load i32, i32* %1
	%4 = sub i32 10, %3
	%5 = icmp ne i32 %4, 0
	br i1 %5, label %do2, label %done3
do2:
	%6 = getelementptr inbounds [13 x i8], [13 x i8]* @.str1, i32 0, i32 0
	%7 = load i32, i32* %1
	%8 = getelementptr inbounds [7 x i8], [7 x i8]* @.str2, i32 0, i32 0
	%9 = getelementptr inbounds [7 x i8], [7 x i8]* @.str5, i32 0, i32 0
	%10 = call i32 (i8*, ...) @printf(i8* %9, i8* %6, i32 %7, i8* %8)
	%11 = getelementptr inbounds [3 x i8], [3 x i8]* @.str6, i32 0, i32 0
	%12 = call i32 (i8*, ...) @scanf(i8* %11, i32* %2)
	%13 = load i32, i32* %1
	%14 = getelementptr inbounds [10 x i32], [10 x i32]* %0, i32 0, i32 %13
	%15 = load i32, i32* %2
	store i32 %15, i32* %14
	%16 = load i32, i32* %1
	%17 = add i32 %16, 1
	store i32 %17, i32* %1
	br label %entry1
done3:
	%18 = getelementptr inbounds [10 x i32], [10 x i32]* %0, i32 0, i32 0
	call void @naivesort(i32* %18, i32 9)
	store i32 0, i32* %1
	br label %entry4
entry4:
	%19 = load i32, i32* %1
	%20 = sub i32 10, %19
	%21 = icmp ne i32 %20, 0
	br i1 %21, label %do5, label %done6
do5:
	%22 = getelementptr inbounds [5 x i8], [5 x i8]* @.str3, i32 0, i32 0
	%23 = load i32, i32* %1
	%24 = getelementptr inbounds [5 x i8], [5 x i8]* @.str4, i32 0, i32 0
	%25 = load i32, i32* %1
	%26 = getelementptr inbounds [10 x i32], [10 x i32]* %0, i32 0, i32 %25
	%27 = load i32, i32* %26
	%28 = getelementptr inbounds [9 x i8], [9 x i8]* @.str7, i32 0, i32 0
	%29 = call i32 (i8*, ...) @printf(i8* %28, i8* %22, i32 %23, i8* %24, i32 %27)
	%30 = load i32, i32* %1
	%31 = add i32 %30, 1
	store i32 %31, i32* %1
	br label %entry4
done6:
	ret void 
}

define void @naivesort(i32*, i32) {
entry:
	%2 = alloca i32*
	%3 = alloca i32
	store i32* %0, i32** %2
	store i32 %1, i32* %3
	%4 = alloca i32
	%5 = alloca i32
	%6 = alloca i32
	%7 = load i32, i32* %3
	%8 = icmp ne i32 %7, 0
	br i1 %8, label %then7, label %fi8
then7:
	%9 = load i32, i32* %3
	%10 = load i32*, i32** %2
	%11 = getelementptr inbounds i32, i32* %10, i32 %9
	%12 = load i32, i32* %11
	store i32 %12, i32* %4
	%13 = load i32, i32* %3
	store i32 %13, i32* %6
	%14 = load i32, i32* %3
	store i32 %14, i32* %5
	br label %entry9
entry9:
	%15 = load i32, i32* %6
	%16 = add i32 %15, 1
	%17 = icmp ne i32 %16, 0
	br i1 %17, label %do10, label %done11
do10:
	%18 = load i32, i32* %6
	%19 = load i32*, i32** %2
	%20 = getelementptr inbounds i32, i32* %19, i32 %18
	%21 = load i32, i32* %20
	%22 = load i32, i32* %4
	%23 = call i32 @plusgrandstrict(i32 %21, i32 %22)
	%24 = icmp ne i32 %23, 0
	br i1 %24, label %then12, label %fi13
then12:
	%25 = load i32, i32* %6
	%26 = load i32*, i32** %2
	%27 = getelementptr inbounds i32, i32* %26, i32 %25
	%28 = load i32, i32* %27
	store i32 %28, i32* %4
	%29 = load i32, i32* %6
	store i32 %29, i32* %5
	br label %fi13
fi13:
	%30 = load i32, i32* %6
	%31 = sub i32 %30, 1
	store i32 %31, i32* %6
	br label %entry9
done11:
	%32 = load i32, i32* %5
	%33 = load i32*, i32** %2
	%34 = getelementptr inbounds i32, i32* %33, i32 %32
	%35 = load i32, i32* %3
	%36 = load i32*, i32** %2
	%37 = getelementptr inbounds i32, i32* %36, i32 %35
	%38 = load i32, i32* %37
	store i32 %38, i32* %34
	%39 = load i32, i32* %3
	%40 = load i32*, i32** %2
	%41 = getelementptr inbounds i32, i32* %40, i32 %39
	%42 = load i32, i32* %4
	store i32 %42, i32* %41
	%43 = load i32*, i32** %2
	%44 = load i32, i32* %3
	%45 = sub i32 %44, 1
	call void @naivesort(i32* %43, i32 %45)
	br label %fi8
fi8:
	ret void 
}

define i32 @plusgrandstrict(i32, i32) {
entry:
	%2 = alloca i32
	%3 = alloca i32
	store i32 %1, i32* %2
	store i32 %0, i32* %3
	%4 = alloca i32
	%5 = alloca i32
	%6 = alloca i32
	%7 = alloca i32
	%8 = load i32, i32* %3
	%9 = load i32, i32* %2
	%10 = mul i32 %8, %9
	store i32 %10, i32* %5
	%11 = load i32, i32* %3
	store i32 %11, i32* %6
	%12 = load i32, i32* %2
	store i32 %12, i32* %7
	br label %entry14
entry14:
	%13 = load i32, i32* %5
	%14 = icmp ne i32 %13, 0
	br i1 %14, label %do15, label %done16
do15:
	%15 = load i32, i32* %7
	%16 = sub i32 %15, 1
	store i32 %16, i32* %7
	%17 = load i32, i32* %6
	%18 = sub i32 %17, 1
	store i32 %18, i32* %6
	%19 = load i32, i32* %6
	%20 = load i32, i32* %7
	%21 = mul i32 %19, %20
	store i32 %21, i32* %5
	br label %entry14
done16:
	%22 = load i32, i32* %6
	%23 = icmp ne i32 %22, 0
	br i1 %23, label %then17, label %else18
then17:
	store i32 1, i32* %4
	br label %fi19
else18:
	store i32 0, i32* %4
	br label %fi19
fi19:
	%24 = load i32, i32* %4
	ret i32 %24
}


