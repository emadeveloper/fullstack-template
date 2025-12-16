import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import { Button } from '../ui/Button';
import Logo from "../../docs/img/la-resistencia-logo-1.jpg";

const HeroSection = () => {
  const [currentSlide, setCurrentSlide] = useState(0);

  const slides = [
    {
      id: 1,
      title: 'Transformá tu cuerpo',
      subtitle: 'La disciplina es el puente entre tus metas y tus logros',
      description: 'Cada entrenamiento te acerca más a la mejor versión de vos mismo',
      category: 'Ejercicio',
      image: Logo, // Placeholder for image
    },
    {
      id: 2,
      title: 'Alimentá tu éxito',
      subtitle: 'Tu cuerpo es un templo, nutrí tu mente y fortalecé tu espíritu',
      description: 'La nutrición adecuada es la base de todo progreso físico',
      category: 'Nutrición',
      image: '', // Placeholder for image
    },
    {
      id: 3,
      title: 'Superá tus límites',
      subtitle: 'El dolor que sentís hoy será la fuerza que tendrás mañana',
      description: 'No te rindas cuando estés cerca. El éxito está a un paso más',
      category: 'Motivación',
      image: '', // Placeholder for image
    },
    {
      id: 4,
      title: 'Construyí tu mejor versión',
      subtitle: 'La consistencia supera a la perfección',
      description: 'Pequeños pasos diarios llevan a grandes transformaciones',
      category: 'Ejercicio',
      image: '', // Placeholder for image
    },
    {
      id: 5,
      title: 'Combustible para el cambio',
      subtitle: 'Lo que comes determina cómo te sentís y cómo te ves',
      description: 'Elegí alimentos que te den energía, no que te la quiten',
      category: 'Nutrición',
      image: '', // Placeholder for image
    },
  ];

  // Auto-play carousel
  useEffect(() => {
    const interval = setInterval(() => {
      setCurrentSlide((prev) => (prev + 1) % slides.length);
    }, 5000); // Change slide every 5 seconds

    return () => clearInterval(interval);
  }, [slides.length]);

  const goToSlide = (index) => {
    setCurrentSlide(index);
  };

  const goToPrevious = () => {
    setCurrentSlide((prev) => (prev - 1 + slides.length) % slides.length);
  };

  const goToNext = () => {
    setCurrentSlide((prev) => (prev + 1) % slides.length);
  };

  return (
    <div className="relative w-full h-screen overflow-hidden">
      {/* Carousel Container */}
      <div className="relative w-full h-full">
        {slides.map((slide, index) => (
          <div
            key={slide.id}
            className={`absolute inset-0 transition-opacity duration-1000 ease-in-out ${
              index === currentSlide ? 'opacity-100 z-10' : 'opacity-0 z-0'
            }`}
          >
            {/* Background Image Placeholder */}
            <div className="absolute inset-0 bg-linear-to-br from-black via-gray-900 to-black">
              {slide.image ? (
                <img
                  src={slide.image}
                  alt={slide.title}
                  className="w-full h-full object-cover opacity-60 sm:object-fill"
                />
              ) : (
                <div className="w-full h-full bg-linear-to-br from-red-800 via-gray-900 to-black" />
              )}
              {/* Overlay for better text readability */}
              <div className="absolute inset-0 bg-black/50" />
            </div>

            {/* Content Overlay */}
            <div className="relative z-20 h-full flex items-center justify-center">
              <div className="max-w-4xl mx-auto px-4 sm:px-6 lg:px-8 text-center">
                {/* Category Badge */}
                <div className="mb-6">
                  <span className="inline-block px-4 py-2 bg-primary/20 border border-primary rounded-full text-primary text-sm font-bold uppercase tracking-wider">
                    {slide.category}
                  </span>
                </div>

                {/* Title */}
                <h1 className="text-4xl md:text-6xl lg:text-7xl font-bold text-white mb-6 leading-tight">
                  {slide.title}
                </h1>

                {/* Subtitle */}
                <h2 className="text-xl md:text-2xl lg:text-3xl text-secondary font-semibold mb-4">
                  {slide.subtitle}
                </h2>

                {/* Description */}
                <p className="text-lg md:text-xl text-gray-300 mb-8 max-w-2xl mx-auto">
                  {slide.description}
                </p>

                {/* CTA Buttons */}
                <div className="flex flex-col sm:flex-row gap-4 justify-center items-center">
                  <Link to="/register">
                    <Button className="px-8 py-3 text-lg">
                      Comenzar Ahora
                    </Button>
                  </Link>
                  <Link to="#planes">
                    <Button variant="secondary" className="px-8 py-3 text-lg">
                      Ver Planes
                    </Button>
                  </Link>
                </div>
              </div>
            </div>
          </div>
        ))}
      </div>

      {/* Navigation Arrows */}
      <button
        onClick={goToPrevious}
        className="absolute left-4 top-1/2 -translate-y-1/2 z-30 p-3 bg-black/50 hover:bg-primary/80 text-white rounded-full transition-all duration-300 hover:scale-110"
        aria-label="Previous slide"
      >
        <svg
          className="w-6 h-6"
          fill="none"
          stroke="currentColor"
          viewBox="0 0 24 24"
        >
          <path
            strokeLinecap="round"
            strokeLinejoin="round"
            strokeWidth={2}
            d="M15 19l-7-7 7-7"
          />
        </svg>
      </button>

      <button
        onClick={goToNext}
        className="absolute right-4 top-1/2 -translate-y-1/2 z-30 p-3 bg-black/50 hover:bg-primary/80 text-white rounded-full transition-all duration-300 hover:scale-110"
        aria-label="Next slide"
      >
        <svg
          className="w-6 h-6"
          fill="none"
          stroke="currentColor"
          viewBox="0 0 24 24"
        >
          <path
            strokeLinecap="round"
            strokeLinejoin="round"
            strokeWidth={2}
            d="M9 5l7 7-7 7"
          />
        </svg>
      </button>

      {/* Dots Indicator */}
      <div className="absolute bottom-8 left-1/2 -translate-x-1/2 z-30 flex space-x-3">
        {slides.map((_, index) => (
          <button
            key={index}
            onClick={() => goToSlide(index)}
            className={`transition-all duration-300 rounded-full ${
              index === currentSlide
                ? 'w-12 h-3 bg-primary'
                : 'w-3 h-3 bg-white/50 hover:bg-white/75'
            }`}
            aria-label={`Go to slide ${index + 1}`}
          />
        ))}
      </div>

      {/* Slide Counter */}
      <div className="absolute top-8 right-8 z-30">
        <div className="bg-black/50 backdrop-blur-sm px-4 py-2 rounded-full">
          <span className="text-white text-sm font-medium">
            {currentSlide + 1} / {slides.length}
          </span>
        </div>
      </div>
    </div>
  );
};

export default HeroSection;

