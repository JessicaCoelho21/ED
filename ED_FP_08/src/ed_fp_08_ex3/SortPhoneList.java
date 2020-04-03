package ed_fp_08_ex3;

public class SortPhoneList {

    public static void main(String[] args) {
        Contact[] amiguinhos = new Contact[7];

        amiguinhos[0] = new Contact("Clark", "Kent", "610-555-7384");
        amiguinhos[1] = new Contact("Bruce", "Wayne", "215-555-3827");
        amiguinhos[2] = new Contact("Peter", "Parker", "733-555-2969");
        amiguinhos[3] = new Contact("James", "Howlett", "663-555-3984");
        amiguinhos[4] = new Contact("Steven", "Rogers", "464-555-3489");
        amiguinhos[5] = new Contact("Britt", "Reid", "322-555-2284");
        amiguinhos[6] = new Contact("Matt", "Murdock", "243-555-2837");
        
        SortingAndSearching.selectionSort(amiguinhos);
        
        for (int index = 0; index < amiguinhos.length; index++) {
            System.out.println(amiguinhos[index]);
        }
    }
}
