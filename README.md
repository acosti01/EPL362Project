# EPL362Project
**Αρχικά:**

O server και η Βάση Δεδομένων βρίσκονται στο localhost οπότε πρέπει να είναι 
εγκατηστημένο το XAMPP και ανοιχτά το Apache Web Server και το MySQL Database
services.

Οδηγίες για την εγκατάσταση του ΧΑΜΡΡ μπορούν να βρεθούν εδώ: 
        
        https://www.apachefriends.org/index.html

Μετά την εγκατάσταση του XAMPP, ανοίγουμε το πρόγραμμα και ξεκινούμε τις υπηρεσίες 
Apache Web Server και MySQL Database όπως αναφέραμε πιο πάνω.

Όταν ξεκινήσουν επιτυχώς οι 2 αυτές υπηρεσίες ανοίγουμε ένα web browser και 
μεταφερόμαστε στο URL: 

		127.0.0.1/phpmyadmin

Μεταφερόμαστε στο tab Import και μέσω του browse βρίσκουμε το φάκελο fill_tables_sql
και επιλέγουμε το sql script που βρίσκεται στο φάκελο αυτό. Το αρχείο που πρέπει 
να γίνει import είναι το EPL362DB.sql το οποίο δημιουργεί τη Βάση Δεδομένων με 
το όνομα EPL362DB, δημιουργεί τα tables και εισάγει τα δεδομένα στους πίνακες.

**Εκτέλεση:**

Για την εκτέλεση του προγράμματος δημιουργήσαμε ένα .bat file(RUN_WINDOWS.bat) 
το οποίο κάνει compile όλα τα .java files μέσα στον src φάκελο του project μας. 

Ακολούθως ξεκινά το RMIRegistry και ξεκινά τον server όπου ενώνεται και με την 
Βάση Δεδομένων που δημιουργήσαμε.

Μέσω της Eclipse στο project, στο φάκελο src και στο package application ανοίγουμε
το mainApplication.java και το τρέχουμε.

Ακολούθως θα εμφανιστεί το το GUI του login.

Για τη σύνδεση και την εμφάνιση των κατάλληλων διαπροσωπειών μπορούμε να εισάγουμε:

**Receptionist:**

		Username: a
		Password: a

**Clinical Staff:**

		Username: b
		Password: b		

**Medical Records Staff:**

		Username: c
		Password: c
		

**Έλεγχος:**

Για τον έλεγχο υπάρχει το package test και ξεκινούμε το mainApplicationTest.java το 
οποίο περιέχει τα testing σχετικά με τις λειτουργίες του server και της Βάσης Δεδομένων.
Προϋπόθεση για να τρέξουν σωστά οι ελέγχοι είναι να τρέχει ο server που ξεκινήσαμε πιο
πριν με το .bat file.

