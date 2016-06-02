
import java.util.ArrayList;

public class ProblemManagement {
    private static ArrayList<Problem> problems = new ArrayList<Problem>();
    private static Problem problem;
    private static int question = 0, lineNumber;
    
  //@formatter:off
    // Sets everything. Call this or everything will throw errors
    public static void init() {
	problem = new Problem("What unit are charges measured in?", "Coulomb", "Volt", "Ampere", "Newton", "Watt", "Coulomb", "");
	problems.add(problem);
	problem = new Problem("What unit are electric potentials measured in?", "Coulomb", "Volt", "Ampere", "Teslas", "Watt", "Volt", "");
	problems.add(problem);
	problem = new Problem("What unit is current measured in?", "Farad", "Volt", "Ampere", "Ohm", "Watt", "Ampere", "");
	problems.add(problem);
	problem = new Problem("What unit is resistance measured in?", "Coulomb", "Volt", "Ampere", "Ohm", "Watt", "Ohm", "");
	problems.add(problem);
	problem = new Problem("What unit is power measured in?", "Coulomb", "Volt", "Ampere", "Teslas", "Watt", "Watt", "");
	problems.add(problem);
	problem = new Problem("What unit is capacitance measured in?", "Coulomb", "Farad", "Ampere", "Ohm", "Watt", "Farad", "");
	problems.add(problem);
	problem = new Problem("Three charges from left to right, A, B, and C, exist in a region of space. Charge A attracts B and B repels C. If A is positive, what is the sign of charge C?", "Positive", "Negative", "Left", "Right", "Neutral", "Negative", "A is positive and attracts B so B is negative. B repels C so C is also negative.");
	problems.add(problem);
	problem = new Problem("Three charges from left to right, A, B, and C, exist in a region of space. Charge A attracts B and B repels C. If A is negative, what is the sign of charge C?", "Positive", "Negative", "Left", "Right", "Neutral", "Positive", "A is negative and attracts B so B is positive. B repels C so C is also positive.");
	problems.add(problem);
	problem = new Problem("Two charged particles are identical other than their charge. One is (-∞,0) C and the other is (0,∞) C. What interaction do they undergo?", "Attraction", "Repulsion", "Explosion", "Nothing", "Magnetism", "Attraction", "Opposite charges attract.");
	problems.add(problem);
	problem = new Problem("Two charged particles are identical other than their charge. One is (-∞,0) C and the other is (-∞,0) C. What interaction do they undergo?", "Attraction", "Repulsion", "Explosion", "Nothing", "Magnetism", "Repulsion", "Same-sign charges repulse.");
	problems.add(problem);
	problem = new Problem("Two charged particles are identical other than their charge. One is (0,∞) C and the other is (0,∞) C. What interaction do they undergo?", "Attraction", "Repulsion", "Explosion", "Nothing", "Magnetism", "Repulsion", "Same-sign charges repulse.");
	problems.add(problem);
	problem = new Problem("Two charges (q_1 and q_2) are separated by a distance r. What happens to force F if the charge on q_1 is doubled?", "0.25 F", "0.5 F", "1 F", "2 F", "4 F", "2 F", "F=(kq_1q_2)/d^2");
	problems.add(problem);
	problem = new Problem("Two charges (q_1 and q_2) are separated by a distance r. What happens to force F if the charge on q_2 is halved?", "0.25 F", "0.5 F", "1 F", "2 F", "4 F", "0.5 F", "F=(kq_1q_2)/d^2");
	problems.add(problem);
	problem = new Problem("Two charges (q_1 and q_2) are separated by a distance r. What happens to force F if the distance is doubled?", "0.25 F", "0.5 F", "1 F", "2 F", "4 F", "0.25 F", "F=(kq_1q_2)/d^2");
	problems.add(problem);
	problem = new Problem("Two charges (q_1 and q_2) are separated by a distance r. What happens to force F if a charge and the distance are halved?", "0.25 F", "0.5 F", "1 F", "2 F", "4 F", "2 F", "F=(kq_1q_2)/d^2");
	problems.add(problem);
	problem = new Problem("What unit is magnetic field measured in?", "Tesla", "Newtons", "Tesla*Meters/Ampere", "Tesla*Meters Square", "Volts", "Tesla", "");
	problems.add(problem);
	problem = new Problem("What unit is the force of magnetism measured in?", "Tesla", "Newtons", "Tesla*Meters/Ampere", "Tesla*Meters Square", "Volts", "Newtons", "");
	problems.add(problem);
	problem = new Problem("What unit is permeability of free space measured in?", "Tesla", "Newtons", "Tesla*Meters/Ampere", "Tesla*Meters Square", "Volts", "Tesla*Meters/Ampere", "");
	problems.add(problem);
	problem = new Problem("What unit is magnetic flux measured in?", "Tesla", "Newtons", "Tesla*Meters/Ampere", "Tesla*Meters Square", "Volts", "Tesla*Meters Square", "");
	problems.add(problem);
	problem = new Problem("What unit is emf measured in?", "Tesla", "Newtons", "Tesla*Meters/Ampere", "Tesla*Meters Square", "Volts", "Volts", "");
	problems.add(problem);
	problem = new Problem("What are domains?", "Territory of an animal", "Groups of atoms with different. magnetic orientation", "Groups of atoms with similar. magnetic orientation", "Areas with magnetic fields", "Regions with electric fields", "Groups of atoms with similar. magnetic orientation", "");
	problems.add(problem);
	problem = new Problem("When finding the direction of magnetic fields using the. right-hand rule, what indicates field direction?", "The direction of the thumb", "The direction of the palm", "The direction of the curled fingers", "The direction of the current", "Out of the paper", "The direction of the curled fingers", "For right hand rule, point thumb in the direction of the current. The direction of the curled fingers indicates field direction.");
	problems.add(problem);
	problem = new Problem("What is the constant μ_0?", "The coefficient of friction", "The coefficient of electricity", "The coefficient of magnetism", "The permeability of free space", "The magnetic flux", "The permeability of free space", "");
	problems.add(problem);
	problem = new Problem("What is the formula for the magnitude of the magnetic field, B,* of a long, straight current-carrying wire?", "B = (μ_0I)/(2πr)", "B = μ_0I", "B = I/(2πr)", "B = μ_0/(2πr)", "B = Ir", "B = (μ_0I)/(2πr)", "");
	problems.add(problem);
	problem = new Problem("What is the equation for the force of magnetism on a. moving charge in a uniform magnetic field?", "FB = qvB", "FB = qB", "FB = μ_0qI", "FB = 2πrB", "FB = μ_0qB", "FB = qvB", "");
	problems.add(problem);
	problem = new Problem("What is the resulting motion of a magnetic field?", "Circular motion perpendicular. to the field", "Linear acceleration parallel. to the field", "Linear acceleration in the direction. of the field", "Simple harmonic motion", "No motion", "Circular motion perpendicular. to the field", "");
	problems.add(problem);
	problem = new Problem("When finding the direction of the force of magnetism* using the right-hand rule, what indicates the direction of the force?", "The direction of the thumb", "The direction of the fingers", "The direction the palm faces", "The direction of the back of the hand", "None of the above", "The direction the palm faces", "");
	problems.add(problem);
	problem = new Problem("A charge, q, moving at at a speed of v enters a uniform magnetic field, B. Determine the radius of the circular path.", "r = (mv^2)/(qB)", "r = (mv)/(qB)", "r = (mv^2)", "r = (mv^2)/q", "r = (mv^2)/B", "r = (mv2)/(qB)", "");
	problems.add(problem);
	problem = new Problem("What is the equation for the magnetic force on a* wire in an external magnetic field?", "FB = qvB", "FB = qIB", "FB = ILB", "FB = qIL", "FB = μ_0qI", "FB = ILB", "");
	problems.add(problem);
	problem = new Problem("Which of the following does not increase the amount* of voltage induced in a coil of wire?", "Move the magnet faster", "Move a stronger magnet", "Use more wire", "Move multiple magnets", "Move both magnets and wire. at the same speed", "Move both magnets and wire. at the same speed", "");
	problems.add(problem);
	problem = new Problem("What is magnetic flux?", "When an electric potential is induced", "When the current reaches a maximum", "When the force of magnetism. reaches a maximum", "A change in the magnetic field", "All of the above", "A change in the magnetic field", "");
	problems.add(problem);
	problem = new Problem("What is an emf?", "When an electric potential is induced", "When the current reaches a maximum", "When the force of magnetism. reaches a maximum", "A change in the magnetic field", "All of the above", "When an electric potential is induced", "");
	problems.add(problem);
	problem = new Problem("What is the equation for magnetic flux?", "Φ = BA", "Φ = BI", "Φ = Bmv^2", "Φ = Bq", "Φ = AI", "Φ = BA", "");
	problems.add(problem);
	problem = new Problem("What is the equation for an emf?", "ϵ = (ΔΦ)/t", "ϵ = ΔΦ", "ϵ = (ΔΦ)/(2πr)", "ϵ = ΔΦB", "ϵ = BLv", "ϵ = (ΔΦ)/t", "");
	problems.add(problem);
	problem = new Problem("What is the equation of a motional emf?", "ϵ = (ΔΦ)/t", "ϵ = ΔΦ", "ϵ = (ΔΦ)/(2πr)", "ϵ = ΔΦB", "ϵ = BLv", "ϵ = BLv", "");
	problems.add(problem);
	problem = new Problem("What unit is wavelength measured in?", "Newtons", "Volts", "Meters", "Meters/Second", "None of the above", "Meters", "");
	problems.add(problem);
	problem = new Problem("What unit is the speed of light measured in?", "Newtons", "Volts", "Meters", "Meters/Second", "None of the above", "Meters/Second", "");
	problems.add(problem);
	problem = new Problem("In transverse waves, oscillators vibrate:", "Diagonal to the direction. of wave propagation", "Perpendicular to the direction. of wave propagation", "Parallel to the direction. of wave propagation", "To a minimum degree", "None of the above", "Perpendicular to the direction. of wave propagation", "");
	problems.add(problem);
	problem = new Problem("In longitudinal waves, oscillators vibrate:", "Diagonal to the direction. of wave propagation", "Perpendicular to the direction. of wave propagation", "Parallel to the direction. of wave propagation", "To a minimum degree", "None of the above", "Parallel to the direction. of wave propagation", "");
	problems.add(problem);
	problem = new Problem("What is the amplitude of a wave?", "The range of the graph", "The domain of the graph", "The distance between the. equilibrium line and any. point on the wave", "The distance measured between. two successive identical portions. of a wave", "None of the above", "The distance between the. equilibrium line and any. point on the wave", "");
	problems.add(problem);
	problem = new Problem("What is the wavelength of a wave?", "The range of the graph", "The domain of the graph", "The distance between the equilibrium. and any point on the wave", "The distance measured between two. successive identical portions. of a wave", "None of the above", "The distance measured between two. successive identical portions of a wave", "");
	problems.add(problem);
	problem = new Problem("What is the equation for the speed of a wave?", "v = Aλ", "v = λ/s", "v = (fλ)/s", "v = (Afλ)/s", "v = fλ", "v = fλ", "");
	problems.add(problem);
	problem = new Problem("If you see a wave traveling in only one medium, then the wave has:", "I) Constant wave speed", "II) Constant frequency", "III) Inverse relationship between. frequency and wavelength", "I and III", "II and III", "I and III", "");
	problems.add(problem);
	problem = new Problem("If you see a wave changing mediums, then the wave has:", "I) Constant wave speed", "II) Constant frequency", "III) Direct relationship between. velocity and wavelength", "I and III", "II and III", "II and III", "");
	problems.add(problem);
	problem = new Problem("A wave travels through a medium with velocity v, frequency f, and wavelength λ. If the wave travels then enters another medium that increases the velocity to 2v,* what will be the corresponding frequency and wavelength?", "f, 2λ", "0.5f, λ", "f, λ", "0.5f, 4λ", "2f, λ", "f, 2λ", "");
	problems.add(problem);
	problem = new Problem("What is the equation for the speed of light moving in a vacuum?", "c = Aλ", "c = λ/s", "c = (fλ)/s", "c = (Afλ)/s", "c = fλ", "c = fλ", "");
	problems.add(problem);
	problem = new Problem("Which electromagnetic wave has the highest energy?", "Infrared", "Ultra-violet", "X-rays", "Gamma rays", "Radio waves", "Gamma rays", "");
	problems.add(problem);
	problem = new Problem("Which electromagnetic wave has the lowest energy?", "Infrared", "Ultra-violet", "X-rays", "Gamma rays", "Radio waves", "Radio waves", "");
	problems.add(problem);
	problem = new Problem("A sound wave has a frequency of f, a velocity of v, and a wavelength of λ. If the frequency were doubled, how would speed and wavelength be affected?", "v, λ", "2v, λ", "v, 2λ", "v/2 , λ", "v, λ/2", "v, λ/2", "");
	problems.add(problem);
	problem = new Problem("When light moving in air enters a block* of glass, which propert(ies) do NOT change?", "Wave speed", "Wavelength", "Frequency", "Both wavelength and frequency", "Both wave speed and wavelength", "Frequency", "");
	problems.add(problem);
	problem = new Problem("As an ambulance siren approaches an observer, the observer will perceive a:", "Frequency increase due to. a wave speed increase", "Frequency increase due to. a wave speed decrease", "Frequency increase due to. a wavelength increase", "Frequency increase due to. a wavelength decrease", "Frequency decrease due to. wavelength increase", "Frequency increase due to. a wavelength decrease", "");
	problems.add(problem);
	problem = new Problem("What characteristic of a wave is affected during the superposition of waves?", "Amplitude", "Frequency", "Pitch", "Wavelength", "Wave speed", "Amplitude", "");
	problems.add(problem);
	problem = new Problem("What is the node of a standing wave?", "(A) Where constructive. interference occurs", "(B) Where destructive. interference occurs", "(C) Where the amplitude is maximum", "(D) A and C", "(E) B and C", "(B) Where destructive. interference occurs", "");
	problems.add(problem);
	problem = new Problem("What are brightness of light and the volume of sound associated with?", "Amplitude", "Frequency", "Wavelength", "Wave speed", "Superposition", "Amplitude", "");
	problems.add(problem);
	problem = new Problem("What is the pitch of a musical instrument and the color of light associated with?", "Amplitude", "Frequency", "Wavelength", "Wave speed", "Superposition", "Frequency", "");
	problems.add(problem);
	problem = new Problem("What does the variable n represent?", "Critical angle", "Radius of curvature", "Focal distance", "Magnification", "Index of refraction", "Index of refraction", "");
	problems.add(problem);
	problem = new Problem("What does the variable θ_c represent?", "Critical angle", "Radius of curvature", "Focal distance", "Magnification", "Index of refraction", "Critical angle", "");
	problems.add(problem);
	problem = new Problem("What does the variable R represent?", "Critical angle", "Radius of curvature", "Focal distance", "Magnification", "Index of refraction", "Radius of curvature", "");
	problems.add(problem);
	problem = new Problem("What does the variable f represent?", "Critical angle", "Radius of curvature", "Focal distance", "Magnification", "Index of refraction", "Focal distance", "");
	problems.add(problem);
	problem = new Problem("What does the variable M represent?", "Critical angle", "Radius of curvature", "Focal distance", "Magnification", "Index of refraction", "Magnification", "");
	problems.add(problem);
	problem = new Problem("What is the law of reflection?", "180 - θ_i = θ_r ", "θ_i = 180 - θ_r", "θ_i = 2θ_r", "2θ_i = θ_r", "θ_i = θ_r", "θ_i = θ_r", "");
	problems.add(problem);
	problem = new Problem("What is the equation for the index of refraction?", "n = v/c", "n = c/v", "n = c^2/v^2", "n = cv", "n = c + v", "n = c/v", "");
	problems.add(problem);
	problem = new Problem("Which of the following is not a characteristic* of an image formed by a plane mirror?", "The image is upright", "The image is the same size. as the object", "The image is a virtual image", "Image distance and object. distance are equal", "The image is inverted", "The image is inverted", "");
	problems.add(problem);
	problem = new Problem("What is Snell’s Law?", "n_1cosθ_1 = n_2cosθ_2", "n_1sinθ_1 = n_2cosθ_2", "n_1sinθ_1 = n_2sinθ_2", "n_1cosθ_1 = n_2sinθ_2", "n_1 = n_2", "n_1sinθ_1 = n_2sinθ_2", "");
	problems.add(problem);
	problem = new Problem("When a light ray is shone from a dense medium into air and* the incident angle is slowly increased, total internal reflection is* first noticed when the incident angle reaches 53o. Determine the index of refraction of the initial dense medium in simplest terms.", "n_1 = 1/(sin53)", "n_1 = (n_2sinθ_2)/(sin53)", "n_1 = n_2/(sin53)", "n_1 = (sinθ_2)/(sin53)", "n_1 = sin53", "n_1 = 1/(sin53)", "");
	problems.add(problem);
	problem = new Problem("What is the equation for the magnification, M, of an image?", "M = (h_i)(h_0)", "M = h_0/h_i", "M = h_i + h_0", "M = h_i - h_0", "M = h_i/h_0", "M = h_i/h_0", "");
	problems.add(problem);
	problem = new Problem("In the case of a concave mirror, an object is initially located at 2f. How will the image change as the object moves toward the focal point f?", "The image will increase in size and. move away from the mirror", "The image will increase in size and. move toward the mirror", "The image will decrease in size and. move away from the mirror", "The image will decrease in size and. move toward the mirror", "The image size remains constant but. moves away from the mirror", "The image will increase in size and. move away from the mirror", "");
	problems.add(problem);
	problem = new Problem("What is a key geometric relationship between the focal length, f, of the lens,* the object distance, do, and the image distance, d_i?", "1/f = 1/d_o + 1/d_i", "f = d_o + d_i", "f = 1/d_o + 1/d_i", "4f = 2d_o + 2d_i", "1/f = 1/d_o - 1/d_i", "1/f = 1/d_o + 1/d_i", "");
	problems.add(problem);
	problem = new Problem("Which of the following is NOT true for a concave lens?", "Concave lens are divergent", "The image is virtual", "The image is upright", "The image is larger than the object", "The image forms on the near side. of the lens", "The image is larger than the object", "");
	problems.add(problem);
	problem = new Problem("Which of the following is true when light enters a denser medium?", "v increases, λ decreases,. and n increases", "v increases, λ decreases,. and n decreases", "v decreases, λ increases,. and n increases", "v decreases, λ decreases,. and n increases", "v decreases, λ decreases,. and n decreases", "v decreases, λ decreases,. and n increases", "");
	problems.add(problem);
    }
  //@formatter:on
    
    public static Problem getProblem() {
	if (question < 1000) { // Sets first 3 questions always (in order).
	    question++;
	    int questionNumber = question - 1;
	    lineNumber = 12 + (2 * questionNumber);
	    return problems.get(questionNumber).randomize();
	} else {
	    int questionNumber = (int) (Math.random() * problems.size());
	    lineNumber = 12 + (2 * questionNumber);
	    return problems.get(questionNumber).randomize();
	}
    }
    
    public static int getLineNumber() {
	return lineNumber;
    }
}
