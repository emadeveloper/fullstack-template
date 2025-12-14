import { Link } from 'react-router-dom';
import { Button } from '../components/ui/Button';
import Navbar from '../components/layout/Navbar';
import Footer from '../components/layout/Footer';
import HeroSection from '../components/layout/HeroSection';
import Plans from '../components/layout/Plans';
import TrainingPrograms from '../components/layout/TrainingPrograms';

export function Home() {
  return (
    <div className="min-h-screen ">
      {/* Navbar */}
      <Navbar />
      {/* Hero Section */}
      <main className="">
        <HeroSection />
        {/* Plans Section */}
        <Plans />
        {/* Features */}
        <TrainingPrograms />
      </main>
      {/* Footer */}
      <Footer />
    </div>
  );
}