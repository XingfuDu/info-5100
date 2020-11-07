import java.util.*;
public class HospitalRoom {
    //TODO: implement your code here
    private static int nOfDoctor = 0;
    private static int nOfPatient = 0;
    private static Queue<String> doctorWaitingList = new LinkedList<>();
    private static Queue<String> patientWaitingList = new LinkedList<>();

    public boolean doctorEnter(Doctor d) throws InterruptedException {
        //TODO: implement your code here
	synchronized(this) {
	    if (nOfDoctor == 0 && doctorWaitingList.isEmpty()) {
		nOfDoctor++;
		System.out.println("Doctor " + d.name + " entered, number of doctor " + nOfDoctor);
		return true;
	    } else if (nOfDoctor == 0 && !doctorWaitingList.isEmpty() && doctorWaitingList.peek().equals(d.name)) {
		nOfDoctor++;
                System.out.println("Doctor " + d.name + " entered, number of doctor " + nOfDoctor);
		doctorWaitingList.poll();
		return true;    
	    } else {
	        if (!doctorWaitingList.contains(d.name)) { 
		    System.out.println("Doctor " + d.name + " is waiting to Enter, number of doctor " + nOfDoctor); 
		    doctorWaitingList.offer(d.name);
		} 
		return false;
	    }
	}
    }

    public boolean doctorLeave(Doctor d) throws InterruptedException {
        //TODO: implement your code here
	synchronized(this) {
	    nOfDoctor--;
	    System.out.println("Doctor " + d.name +" left, number of doctor " + nOfDoctor);
	    return true;
	}
    }

    public boolean patientEnter(Patient p) throws InterruptedException {
        //TODO: implement your code here
	synchronized(this) {
            if (nOfPatient < 3 && patientWaitingList.isEmpty()) {
	   	nOfPatient++;
		System.out.println("Patient " + p.name + " entered, number of patients " + nOfPatient);
		return true;
	    } else if (nOfPatient < 3 && !patientWaitingList.isEmpty() && patientWaitingList.peek().equals(p.name)) {
                nOfPatient++;
                System.out.println("Patient " + p.name + " entered, number of patients " + nOfPatient);
                patientWaitingList.poll();
                return true;
	    } else {
                if (!patientWaitingList.contains(p.name)) {
                    System.out.println("Patient " + p.name + " is waiting to Enter, number of patients " + nOfPatient);
                    patientWaitingList.offer(p.name);
                }
                return false;
            }
	}
    }

    public boolean patientLeave(Patient p) throws InterruptedException {
        //TODO: implement your code here
        synchronized(this) {
            nOfPatient--;
            System.out.println("Patient " + p.name +" left");
	    return true;
        }
    }
        public static void main(String[] args) {
        HospitalRoom room = new HospitalRoom();
        Doctor siva = new Doctor("siva");
        Doctor john = new Doctor("john");
        Patient p1 = new Patient("p1");
        Patient p2 = new Patient("p2");
        Patient p3= new Patient("p3");
        Patient p4 = new Patient("p4");
        Patient p5 = new Patient("p5");
        Thread doctor1 = new Thread(() -> {
		try {
		    while(!room.doctorEnter(siva)) {}
		    Thread.sleep(500);
		    while(!room.doctorLeave(siva)) {}

		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
	    });

        Thread doctor2 = new Thread(() -> {
		try {
		    while(!room.doctorEnter(john)) {}
		    Thread.sleep(500);
		    while(!room.doctorLeave(john)) {}
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
	    });

        Thread patient1 = new Thread(() -> {
		try {
                    while(!room.patientEnter(p1)) {}
		    Thread.sleep(500);
                    while(!room.patientLeave(p1)) {}
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
	    });

        Thread patient2 = new Thread(() -> {
		try {
		    while(!room.patientEnter(p2)) {};
		    Thread.sleep(500);
		    while(!room.patientLeave(p2)) {};
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
	    });

        Thread patient3 = new Thread(() -> {
		try {
		    while(!room.patientEnter(p3)) {};
		    Thread.sleep(500);
		    while(!room.patientLeave(p3)) {};
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
	    });

        Thread patient4 = new Thread(() -> {
		try {
		    while(!room.patientEnter(p4)) {};
		    Thread.sleep(500);
		    while(!room.patientLeave(p4)) {};
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
	    });

        Thread patient5 = new Thread(() -> {
		try {
		    while(!room.patientEnter(p5)) {};
		    Thread.sleep(500);
		    while(!room.patientLeave(p5)) {};
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
	    });

        doctor1.start();
        doctor2.start();
        patient1.start();
        patient2.start();
        patient3.start();
        patient4.start();
        patient5.start();
    }

}

class Doctor {
    public String name;
    public Doctor(String name) {
        this.name = name;
    }
}

class Patient {
    public String name;
    public Patient(String name) {
        this.name = name;
    }
}

class Main2 {
}