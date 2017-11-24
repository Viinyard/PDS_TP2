; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)
declare i32 @scanf(i8* noalias nocapture, ...)

; Actual code begins

@.str1 = private unnamed_addr constant [25 x i8]c"Main: Tableau de taille \00", align 1
@.str2 = private unnamed_addr constant [5 x i8]c" = [\00", align 1
@.str12 = private unnamed_addr constant [7 x i8]c"%s%d%s\00", align 1
@.str3 = private unnamed_addr constant [2 x i8]c",\00", align 1
@.str13 = private unnamed_addr constant [3 x i8]c"%s\00", align 1
@.str14 = private unnamed_addr constant [3 x i8]c"%d\00", align 1
@.str4 = private unnamed_addr constant [3 x i8]c"]\0A\00", align 1
@.str15 = private unnamed_addr constant [3 x i8]c"%s\00", align 1
@.str5 = private unnamed_addr constant [5 x i8]c"Fini\00", align 1
@.str16 = private unnamed_addr constant [3 x i8]c"%s\00", align 1
@.str6 = private unnamed_addr constant [11 x i8]c"entrezno :\00", align 1
@.str7 = private unnamed_addr constant [3 x i8]c"  \00", align 1
@.str17 = private unnamed_addr constant [7 x i8]c"%s%d%s\00", align 1
@.str18 = private unnamed_addr constant [3 x i8]c"%d\00", align 1
@.str8 = private unnamed_addr constant [19 x i8]c"Tableau de taille \00", align 1
@.str9 = private unnamed_addr constant [5 x i8]c" = [\00", align 1
@.str19 = private unnamed_addr constant [7 x i8]c"%s%d%s\00", align 1
@.str10 = private unnamed_addr constant [2 x i8]c",\00", align 1
@.str20 = private unnamed_addr constant [3 x i8]c"%s\00", align 1
@.str21 = private unnamed_addr constant [3 x i8]c"%d\00", align 1
@.str11 = private unnamed_addr constant [3 x i8]c"]\0A\00", align 1
@.str22 = private unnamed_addr constant [3 x i8]c"%s\00", align 1

define void @main() {
entry:
	%0 = alloca i32
	%1 = alloca i32
	%2 = alloca [2 x i32]
	store i32 2, i32* %1
	%3 = load i32, i32* %1
	%4 = getelementptr inbounds [2 x i32], [2 x i32]* %2, i32 0, i32 0
	call void @readprinttab(i32 %3, i32* %4)
	%5 = getelementptr inbounds [25 x i8], [25 x i8]* @.str1, i32 0, i32 0
	%6 = load i32, i32* %1
	%7 = getelementptr inbounds [5 x i8], [5 x i8]* @.str2, i32 0, i32 0
	%8 = getelementptr inbounds [7 x i8], [7 x i8]* @.str12, i32 0, i32 0
	%9 = call i32 (i8*, ...) @printf(i8* %8, i8* %5, i32 %6, i8* %7)
	store i32 0, i32* %0
	br label %entry1
entry1:
	%10 = load i32, i32* %1
	%11 = load i32, i32* %0
	%12 = sub i32 %10, %11
	%13 = icmp ne i32 %12, 0
	br i1 %13, label %do2, label %done3
do2:
	%14 = load i32, i32* %0
	%15 = icmp ne i32 %14, 0
	br i1 %15, label %then4, label %fi5
then4:
	%16 = getelementptr inbounds [2 x i8], [2 x i8]* @.str3, i32 0, i32 0
	%17 = getelementptr inbounds [3 x i8], [3 x i8]* @.str13, i32 0, i32 0
	%18 = call i32 (i8*, ...) @printf(i8* %17, i8* %16)
	br label %fi5
fi5:
	%19 = load i32, i32* %0
	%20 = getelementptr inbounds [2 x i32], [2 x i32]* %2, i32 0, i32 %19
	%21 = load i32, i32* %20
	%22 = getelementptr inbounds [3 x i8], [3 x i8]* @.str14, i32 0, i32 0
	%23 = call i32 (i8*, ...) @printf(i8* %22, i32 %21)
	%24 = load i32, i32* %0
	%25 = add i32 %24, 1
	store i32 %25, i32* %0
	br label %entry1
done3:
	%26 = getelementptr inbounds [3 x i8], [3 x i8]* @.str4, i32 0, i32 0
	%27 = getelementptr inbounds [3 x i8], [3 x i8]* @.str15, i32 0, i32 0
	%28 = call i32 (i8*, ...) @printf(i8* %27, i8* %26)
	%29 = getelementptr inbounds [5 x i8], [5 x i8]* @.str5, i32 0, i32 0
	%30 = getelementptr inbounds [3 x i8], [3 x i8]* @.str16, i32 0, i32 0
	%31 = call i32 (i8*, ...) @printf(i8* %30, i8* %29)
	ret void 
}

define void @readprinttab(i32, i32*) {
entry:
	%2 = alloca i32
	%3 = alloca i32*
	store i32 %0, i32* %2
	store i32* %1, i32** %3
	%4 = alloca i32
	store i32 0, i32* %4
	br label %entry6
entry6:
	%5 = load i32, i32* %2
	%6 = load i32, i32* %4
	%7 = sub i32 %5, %6
	%8 = icmp ne i32 %7, 0
	br i1 %8, label %do7, label %done8
do7:
	%9 = getelementptr inbounds [11 x i8], [11 x i8]* @.str6, i32 0, i32 0
	%10 = load i32, i32* %4
	%11 = getelementptr inbounds [3 x i8], [3 x i8]* @.str7, i32 0, i32 0
	%12 = getelementptr inbounds [7 x i8], [7 x i8]* @.str17, i32 0, i32 0
	%13 = call i32 (i8*, ...) @printf(i8* %12, i8* %9, i32 %10, i8* %11)
	%14 = load i32, i32* %4
	%15 = load i32*, i32** %3
	%16 = getelementptr inbounds i32, i32* %15, i32 %14
	%17 = getelementptr inbounds [3 x i8], [3 x i8]* @.str18, i32 0, i32 0
	%18 = call i32 (i8*, ...) @scanf(i8* %17, i32* %16)
	%19 = load i32, i32* %4
	%20 = add i32 %19, 1
	store i32 %20, i32* %4
	br label %entry6
done8:
	%21 = getelementptr inbounds [19 x i8], [19 x i8]* @.str8, i32 0, i32 0
	%22 = load i32, i32* %2
	%23 = getelementptr inbounds [5 x i8], [5 x i8]* @.str9, i32 0, i32 0
	%24 = getelementptr inbounds [7 x i8], [7 x i8]* @.str19, i32 0, i32 0
	%25 = call i32 (i8*, ...) @printf(i8* %24, i8* %21, i32 %22, i8* %23)
	store i32 0, i32* %4
	br label %entry9
entry9:
	%26 = load i32, i32* %2
	%27 = load i32, i32* %4
	%28 = sub i32 %26, %27
	%29 = icmp ne i32 %28, 0
	br i1 %29, label %do10, label %done11
do10:
	%30 = load i32, i32* %4
	%31 = icmp ne i32 %30, 0
	br i1 %31, label %then12, label %fi13
then12:
	%32 = getelementptr inbounds [2 x i8], [2 x i8]* @.str10, i32 0, i32 0
	%33 = getelementptr inbounds [3 x i8], [3 x i8]* @.str20, i32 0, i32 0
	%34 = call i32 (i8*, ...) @printf(i8* %33, i8* %32)
	br label %fi13
fi13:
	%35 = load i32, i32* %4
	%36 = load i32*, i32** %3
	%37 = getelementptr inbounds i32, i32* %36, i32 %35
	%38 = load i32, i32* %37
	%39 = getelementptr inbounds [3 x i8], [3 x i8]* @.str21, i32 0, i32 0
	%40 = call i32 (i8*, ...) @printf(i8* %39, i32 %38)
	%41 = load i32, i32* %4
	%42 = add i32 %41, 1
	store i32 %42, i32* %4
	br label %entry9
done11:
	%43 = getelementptr inbounds [3 x i8], [3 x i8]* @.str11, i32 0, i32 0
	%44 = getelementptr inbounds [3 x i8], [3 x i8]* @.str22, i32 0, i32 0
	%45 = call i32 (i8*, ...) @printf(i8* %44, i8* %43)
	ret void 
}


